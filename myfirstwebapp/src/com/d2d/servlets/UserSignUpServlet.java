package com.d2d.servlets;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.neo4j.graphdb.GraphDatabaseService;

import com.d2d.servlets.bookstore.UserCRUDOperations;
import com.d2d.servlets.common.Utils;
import com.d2d.servlets.model.User;

@WebServlet( name = "userSignUpServlet", urlPatterns = { "/user/signup" }, initParams = { @WebInitParam( name = "logFileLocation", value = "/tmp/user" ) } )
public class UserSignUpServlet extends HttpServlet
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private BufferedWriter logWriter = null;

    public UserSignUpServlet()
    {
        System.out.println( ">>>>>>>>>>>>>>>>> INSIDE CONSTRUCTOR <<<<<<<<<<<<<<<<<<<" );
    }

    @Override
    public void destroy()
    {
        if ( logWriter != null )
        {
            System.out.println( "Closing the log file....." );
            try
            {
                logWriter.close();
            }
            catch ( IOException e )
            {
                System.err.println( "Unable to close the log file - " + e.getMessage() );
            }
        }
        super.destroy();
    }

    @Override
    public void init() throws ServletException
    {
        String logFileLocation = getServletConfig().getInitParameter( "logFileLocation" );
        if ( logFileLocation != null && logFileLocation.trim().length() > 0 )
        {
            File logFolder = new File( logFileLocation );
            if ( !logFolder.exists() )
            {
                logFolder.mkdir();
            }
            String logFileName = logFolder.getAbsolutePath() + File.separator + "user-"
                    + new Date().toString().replaceAll( " ", "_" ) + ".log";
            try
            {
                logWriter = new BufferedWriter( new FileWriter( logFileName ) );
            }
            catch ( IOException e )
            {
                System.err.println( "Unable to create the log file - " + e.getMessage() );
                logWriter = null;
            }
        }
    }

    public void logRequest( HttpServletRequest request )
    {
        if ( logWriter != null && request != null )
        {
            try
            {
                long currentTime = System.currentTimeMillis();
                Date currentDate = new Date( currentTime );
                logWriter.write( "Request received at : " + currentDate + "(" + currentTime + ")\n" );
                logWriter.write( "Request URI : " + request.getRequestURI() );
                logWriter.write( request.getContextPath() + "/" + request.getContentType() + "/"
                        + request.getCharacterEncoding() );

                StringBuffer sb = new StringBuffer();
                sb.append( request.getScheme() );
                sb.append( "://" );
                sb.append( request.getServerName() );
                sb.append( ":" );
                sb.append( request.getServerPort() );
                sb.append( "/" );
                sb.append( request.getContextPath() );
                sb.append( "/" );
                sb.append( request.getServletPath() );
                sb.append( "/" );
                sb.append( request.getPathInfo() );
                logWriter.write( "\n" + sb.toString() + "\n" );

                Enumeration<String> reqParams = request.getParameterNames();
                if ( reqParams != null && reqParams.hasMoreElements() )
                {
                    logWriter.write( "\nRequest Parameters\n" );
                    while ( reqParams.hasMoreElements() )
                    {
                        String paramName = reqParams.nextElement();
                        String paramValue = request.getParameter( paramName );
                        logWriter.write( paramName + " = " + paramValue + "\n" );
                    }
                }
                Enumeration<String> reqHeaders = request.getHeaderNames();
                if ( reqHeaders != null && reqHeaders.hasMoreElements() )
                {
                    logWriter.write( "\nRequest Headers\n" );
                    while ( reqHeaders.hasMoreElements() )
                    {
                        String headerName = reqHeaders.nextElement();
                        String headerValue = request.getHeader( headerName );
                        logWriter.write( headerName + " = " + headerValue + "\n" );
                    }
                }
                logWriter.flush();
            }
            catch ( IOException e )
            {
                System.err.println( "Unable to write to the log file - " + e.getMessage() );
            }
        }
    }

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException
    {
        logRequest( request );
        response.setContentType( "text/html" );

        Writer writer = response.getWriter();

        RequestDispatcher rd = getServletContext().getRequestDispatcher( "/top.html" );
        rd.include( request, response );

        writer.write( "     <div class='row'>" );
        writer.write( "         <div class='col-sm-3'>" );

        rd = getServletContext().getRequestDispatcher( "/books/recent" );
        rd.include( request, response );

        writer.write( "         </div>" );
        writer.write( "         <div class='col-sm-6'>" );

        rd = getServletContext().getRequestDispatcher( "/signup.html" );
        rd.include( request, response );

        writer.write( "         </div>" );
        writer.write( "         <div class='col-sm-3'></div>" );
        writer.write( "     </div>" );

        rd = getServletContext().getRequestDispatcher( "/bottom.html" );
        rd.include( request, response );

    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException
    {
        logRequest( request );
        response.setContentType( "text/html" );

        User userToCreate = new User();
        userToCreate.setEmail( request.getParameter( "email" ) );
        userToCreate.setPassword( request.getParameter( "password" ) );
        userToCreate.setFirstName( request.getParameter( "firstName" ) );
        userToCreate.setLastName( request.getParameter( "lastName" ) );

        // Create the node with the userName, password &
        // name as the properties on the node
        // What is the label? Users
        // Api to use is createNode(..)
        // Where is the api present? on GraphDatabaseService
        // How do i access GraphDatabaseService?
        // Get the servlet context and on that, access the attribtue
        // "GraphDatabase" which returns a reference to the
        // GraphDatabaseService

        GraphDatabaseService graphDB = Utils.getGraphDatabase( getServletContext() );
        if ( graphDB != null )
        {
            try
            {
                User createdUser = UserCRUDOperations.createUser( graphDB, userToCreate );
                System.out.println( "User Name : " + createdUser.getFirstName() );
                response.sendRedirect( "/bookstore/home" );
            }
            catch ( Exception e )
            {
                e.printStackTrace();
            }
        }
    }
}
