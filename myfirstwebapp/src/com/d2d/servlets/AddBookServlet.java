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

import com.d2d.servlets.bookstore.BooksCRUDOperations;
import com.d2d.servlets.bookstore.UserCRUDOperations;
import com.d2d.servlets.common.Utils;
import com.d2d.servlets.model.Book;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet( urlPatterns = { "/book" } )
public class AddBookServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException
    {
        HttpSession session = request.getSession( false );
        if ( session == null )
        {
            response.sendRedirect( "/bookstore/user/auth/signin" );
            return;
        }

        // Check if the user has logged in
        // We are using the Cookies as the session management
        // Name of the cookie is sessionId
        // Value of the cookie is encrypted email
        //
        // Uncomment the below code if cookies are used for session management.

        // Cookie sessionCookie = Utils.retrieveSessionCookie( request );
        // if ( sessionCookie == null )
        // {
        // RequestDispatcher rd = getServletContext().getRequestDispatcher( "/user/auth/signin" );
        // rd.forward( request, response );
        // return;
        // }

        // Uncomment below line if cookies are used for session management.
        // String encryptedEmail = sessionCookie.getValue();

        Object val = session.getAttribute( Utils.SESSION_ID );
        String encryptedEmail = val != null ? val.toString() : "";
        byte[] byteArray = DatatypeConverter.parseBase64Binary( encryptedEmail );
        String decryptedEmail = new String( byteArray );

        GraphDatabaseService graphDB = Utils.getGraphDatabase( getServletContext() );
        boolean exists = graphDB == null ? false : UserCRUDOperations.emailExists( graphDB, decryptedEmail );
        if ( !exists )
        {
            response.sendRedirect( "/bookstore/user/auth/signin" );
        }

        response.setContentType( "text/html" );

        Writer writer = response.getWriter();

        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                Utils.isUserLoggedIn( request ) ? "/authtop.html" : "/top.html" );
        rd.include( request, response );

        writer.write( "     <div class='row'>" );
        writer.write( "         <div class='col-sm-3'>" );

        rd = getServletContext().getRequestDispatcher( "/books/recent" );
        rd.include( request, response );

        writer.write( "         </div>" );
        writer.write( "         <div class='col-sm-6'>" );

        rd = getServletContext().getRequestDispatcher( "/createbook.html" );
        rd.include( request, response );

        writer.write( "         </div>" );
        writer.write( "         <div class='col-sm-3'></div>" );
        writer.write( "     </div>" );

        rd = getServletContext().getRequestDispatcher( "/bottom.html" );
        rd.include( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException
    {
        if( !Utils.isUserLoggedIn( request ) )
        {
            response.sendRedirect( "/bookstore/user/auth/signin" );
        }
        Book b = new Book();
        b.setTitle( request.getParameter( "title" ) );
        b.setIsbnCode( request.getParameter( "isbnCode" ) );
        b.setAuthor( request.getParameter( "author" ) );
        b.setPrice( new Double( request.getParameter( "price" ) ).doubleValue() );
        b.setPublishedYear( request.getParameter( "publishedYear" ) );

        GraphDatabaseService graphDB = Utils.getGraphDatabase( getServletContext() );
        if ( graphDB != null )
        {
            BooksCRUDOperations.createBook( graphDB, b );

            response.sendRedirect( "/bookstore/home" );
        }
    }

}
