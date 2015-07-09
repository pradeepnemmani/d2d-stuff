package com.d2d.servlets;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.d2d.servlets.common.Utils;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet( name = "homeServlet", urlPatterns = { "/home" } )
public class HomeServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet()
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

        StringBuffer sb = new StringBuffer();

        // Include top.html
        RequestDispatcher rd = getServletContext().getRequestDispatcher( Utils.isUserLoggedIn( request ) ? "/authtop.html" : "/top.html" );
        rd.include( request, response );

        sb.append( "     <div class='row'>" );
        sb.append( "         <div class='col-sm-3'>" );
        writer.write( sb.toString() );

        rd = getServletContext().getRequestDispatcher( "/books/recent" );
        rd.include( request, response );

        sb = new StringBuffer();
        sb.append( "         </div>" );
        sb.append( "         <div class='col-sm-6'>" );
        sb.append( "             <div class='panel panel-default'>" );
        sb.append( "                 <div class='panel-heading'>" );
        sb.append( "                     <h4>Search for Books</h4>" );
        sb.append( "                 </div>" );
        sb.append( "                 <div class='panel-body'>" );
        sb.append( "                     <form role='form'>" );
        sb.append( "                       <div class='form-group'>" );
        sb.append( "                         <label class='col-sm-3' for='searchText'>Search Text</label>" );
        sb.append( "                         <div class='col-sm-9'>" );
        sb.append( "                             <input type='text' class='form-control' id='searchText' placeholder='Enter your search text'/>" );
        sb.append( "                         </div>" );
        sb.append( "                       </div>" );
        sb.append( "                       <div class='form-group'>" );
        sb.append( "                         <div class='col-sm-12'>" );
        sb.append( "                             <hr/>" );
        sb.append( "                         </div>" );
        sb.append( "                       </div>" );
        sb.append( "                       <div class='form-group'>" );
        sb.append( "                         <div class='col-sm-3'></div>" );
        sb.append( "                         <div class='col-sm-2'>" );
        sb.append( "                             <button type='submit' class='btn btn-default'><i class='fa fa-search fa-2x'></i> Search</button>" );
        sb.append( "                         </div>" );
        sb.append( "                       </div>" );
        sb.append( "                     </form>     " );
        sb.append( "                 </div>" );
        sb.append( "             </div>" );
        sb.append( "         </div>" );
        sb.append( "         <div class='col-sm-3'>" );
        sb.append( "             <div class='panel panel-default'>" );
        sb.append( "                 <div class='panel-heading'>" );
        sb.append( "                     <h4><i class='fa fa-bolt' style='color:red;'></i> Hot Books</h4>" );
        sb.append( "                 </div>" );
        sb.append( "                 <div class='panel-body'>" );
        sb.append( "                 </div>" );
        sb.append( "             </div>" );
        sb.append( "         </div>" );
        sb.append( "     </div>" );
        writer.write( sb.toString() );

        RequestDispatcher rd1 = getServletContext().getRequestDispatcher( "/bottom.html" );
        rd1.include( request, response );

    }

}
