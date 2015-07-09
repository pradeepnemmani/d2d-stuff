package com.d2d.servlets;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.neo4j.graphdb.GraphDatabaseService;

import com.d2d.servlets.bookstore.BooksCRUDOperations;
import com.d2d.servlets.common.Utils;
import com.d2d.servlets.model.Book;

/**
 * Servlet implementation class RecentBooksServlet
 */
@WebServlet( "/books/recent" )
public class RecentBooksServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecentBooksServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException
    {
        response.setContentType( "text/html" );

        Writer writer = response.getWriter();
        List<Book> recentBooks = null;

        GraphDatabaseService graphDB = Utils.getGraphDatabase( getServletContext() );
        if ( graphDB != null )
        {
            recentBooks = BooksCRUDOperations.getRecentBooks( graphDB );
        }

        StringBuffer sb = new StringBuffer();
        sb.append( " <div class='panel panel-default'>" );
        sb.append( "     <div class='panel-heading'>" );
        sb.append( "         <h4><i class='fa fa-book'></i> Recent Books</h4>" );
        sb.append( "     </div>" );
        sb.append( "     <div class='panel-body'>" );
        if ( recentBooks != null && !recentBooks.isEmpty() )
        {
            for ( Book book : recentBooks )
            {
                sb.append( "         <div class='thumbnail'>" );
                sb.append( "             <div class='caption'>" );
                sb.append( "                 <h4>" + book.getTitle() + "</h4>" );
                sb.append( "                 <p>" + book.getAuthor() + "</p>" );
                sb.append( "                 <p><em>" + book.getIsbnCode() + "</em></p>" );
                sb.append( "             </div>" );
                sb.append( "         </div>" );
            }
        }
        else
        {
            String encryptedUrl = response.encodeURL( "/bookstore/book" );
            System.out.println( encryptedUrl );
            sb.append( "<a href='" + encryptedUrl + "'><i class='fa fa-plus-square fa-2x'></i> Add Book</a>" );
        }

        sb.append( "     </div>" );
        sb.append( " </div>" );
        writer.write( sb.toString() );
    }

}
