package com.d2d.servlets;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import org.neo4j.graphdb.GraphDatabaseService;

import com.d2d.servlets.bookstore.UserCRUDOperations;
import com.d2d.servlets.common.Utils;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet( "/user/auth/*" )
public class AuthenticationServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException
    {
        String pathInfo = request.getPathInfo();

        if ( pathInfo != null )
        {
            if ( pathInfo.startsWith( "/signin" ) )
            {
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

                rd = getServletContext().getRequestDispatcher( "/signin.html" );
                rd.include( request, response );

                writer.write( "         </div>" );
                writer.write( "         <div class='col-sm-3'></div>" );
                writer.write( "     </div>" );

                rd = getServletContext().getRequestDispatcher( "/bottom.html" );
                rd.include( request, response );
            }
            else if ( pathInfo.startsWith( "/signout" ) )
            {
                HttpSession session = request.getSession( false );
                if ( session != null )
                {
                    session.removeAttribute( Utils.SESSION_ID );
                    session.invalidate();
                }
                // Uncomment the below lines if cookies are used for session management
                //
                // Cookie sessionCookie = Utils.retrieveSessionCookie( request );
                // sessionCookie.setDomain( "localhost" );
                // sessionCookie.setPath( "/" );
                // sessionCookie.setMaxAge( 0 );
                // response.addCookie( sessionCookie );

                response.sendRedirect( response.encodeRedirectURL( "/bookstore/home" ) );
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException
    {
        String pathInfo = request.getPathInfo();
        if ( pathInfo != null && pathInfo.startsWith( "/signin" ) )
        {
            String email = request.getParameter( "email" );
            String password = request.getParameter( "password" );
            if ( email != null && email.length() > 0 && password != null && password.length() > 0 )
            {
                GraphDatabaseService graphDB = Utils.getGraphDatabase( getServletContext() );
                if ( graphDB != null )
                {
                    boolean verdict = UserCRUDOperations.authenticate( graphDB, email, password );
                    if ( verdict )
                    {
                        // Valid login.
                        // As we are using Cookies for session management,
                        // let us create a Cookie whose name is sessionId
                        // and the value is an encrypted email
                        String encryptedEmail = DatatypeConverter.printBase64Binary( email.getBytes() );

                        HttpSession session = request.getSession( true );
                        session.setAttribute( Utils.SESSION_ID, encryptedEmail );

                        // Uncomment the below lines if you want to go through Cookies for session management.
                        //
                        // Cookie sessionIdCookie = new Cookie( Utils.SESSION_ID, encryptedEmail.toString() );
                        // sessionIdCookie.setDomain( "localhost" );
                        // sessionIdCookie.setMaxAge( 300 );
                        // sessionIdCookie.setPath( "/" );
                        // response.addCookie( sessionIdCookie );
                        response.sendRedirect( response.encodeRedirectURL( "/bookstore/home" ) );
                        return;
                    }
                }
                response.sendRedirect( "/bookstore/user/auth/signin" );
            }
        }

    }
}
