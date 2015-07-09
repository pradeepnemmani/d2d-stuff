package com.d2d.servlets;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetingServlet extends HttpServlet
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException
    {
        response.setContentType( "text/html" );
        Writer out = response.getWriter();

        StringBuffer sb = new StringBuffer();
        sb.append( "<html>" );
        sb.append( " <head>" );
        sb.append( "     <title>Greeting Form</title>" );
        sb.append( " </head>" );
        sb.append( " <body>" );
        sb.append( "     <p>Please enter the username and the greeting</p>" );
        sb.append( "     <hr/>" );
        sb.append( "     <form method='POST' action='/greeting'>" );
        sb.append( "         <table>" );
        sb.append( "             <tbody>" );
        sb.append( "                 <tr>" );
        sb.append( "                     <td>User Name:</td>" );
        sb.append( "                     <td>" );
        sb.append( "                         <input type='text' id='userName' name='userName' placeholder='User Name'/>" );
        sb.append( "                     </td>" );
        sb.append( "                 </tr>" );
        sb.append( "                 <tr>" );
        sb.append( "                     <td>Your Message</td>" );
        sb.append( "                     <td>" );
        sb.append( "                         <textarea id='message' name='message' cols='48' rows='5'></textarea>" );
        sb.append( "                     </td>" );
        sb.append( "                 </tr>" );
        sb.append( "             </tbody>" );
        sb.append( "         </table>" );
        sb.append( "         <hr/>" );
        sb.append( "         <input type='submit' value='Greet'/>" );
        sb.append( "     </form>" );
        sb.append( " </body>" );
        sb.append( "</html>" );

        out.write( sb.toString() );
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException
    {
        String userName = request.getParameter( "userName" );
        String message = request.getParameter( "message" );

        response.setContentType( "text/html" );

        StringBuffer sb = new StringBuffer();

        sb.append( "<html>" );
        sb.append( " <head>" );
        sb.append( "     <title>Greeting from someone!</title>" );
        sb.append( " </head>" );
        sb.append( " <body>" );
        sb.append( "     <p>" );
        sb.append( "         <h1>Welcome " );
        sb.append( userName );
        sb.append( "         !!!</h1>" );
        sb.append( "     </p>" );
        sb.append( "     <p>" );
        sb.append( "         <h3>Message from your loved one!</h3>" );
        sb.append( "<em>" );
        sb.append( message );
        sb.append( "</em>" );
        sb.append( "     </p>" );
        sb.append( " </body>" );
        sb.append( "</html>" );

        response.getWriter().write( sb.toString() );
    }

}
