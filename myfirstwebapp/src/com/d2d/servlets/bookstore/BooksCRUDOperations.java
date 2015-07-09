package com.d2d.servlets.bookstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterable;
import org.neo4j.graphdb.Transaction;

import com.d2d.servlets.model.Book;

public class BooksCRUDOperations
{
    private static final String RECENT_BOOKS_QUERY = "MATCH (book:Books) WHERE book.creationTime >= {timeLimit} RETURN book.title AS title, book.isbnCode AS isbnCode, book.author AS author, book.publishedYear AS pubYear, book.price AS price";
    private static final int RECENT_TIME_LIMIT = 5 * 60 * 1000;

    private BooksCRUDOperations()
    {
        // private constructor
    }

    public static Book createBook( GraphDatabaseService gds, Book book )
    {
        if ( gds != null && book.getTitle() != null && book.getTitle().length() > 0 && book.getIsbnCode() != null
                && book.getIsbnCode().length() > 0 && book.getPrice() > 0 )
        {
            try ( Transaction tx = gds.beginTx() )
            {
                Label booksLabel = DynamicLabel.label( "Books" );
                Node bookNode = gds.createNode( booksLabel );
                bookNode.setProperty( "title", book.getTitle() );
                bookNode.setProperty( "isbnCode", book.getIsbnCode() );
                bookNode.setProperty( "publishedYear", book.getPublishedYear() );
                bookNode.setProperty( "price", new Double( book.getPrice() ) );
                bookNode.setProperty( "author", book.getAuthor() );
                bookNode.setProperty( "creationTime", System.currentTimeMillis() );
                tx.success();
                return book;
            }
        }
        return null;
    }

    public static List<Book> getRecentBooks( GraphDatabaseService gds )
    {
        List<Book> recentBooks = new ArrayList<>();

        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put( "timeLimit", System.currentTimeMillis() - RECENT_TIME_LIMIT );

        ExecutionEngine ee = new ExecutionEngine( gds );

        ExecutionResult er = ee.execute( RECENT_BOOKS_QUERY, queryParameters );
        if ( er != null && er.iterator().hasNext() )
        {
            for ( Map<String, Object> record : er )
            {
                Book b = new Book();

                b.setTitle( record.get( "title" ).toString() );
                b.setIsbnCode( record.get( "isbnCode" ).toString() );
                b.setAuthor( record.get( "author" ).toString() );
                b.setPublishedYear( record.get( "pubYear" ).toString() );
                Object p = record.get( "price" );
                b.setPrice( p instanceof Double ? ( (Double) p ).doubleValue() : 0.0 );

                recentBooks.add( b );
            }
        }

        return recentBooks;
    }

    public static Book findBook( GraphDatabaseService gds, String isbnCode )
    {
        Book book = null;

        if ( gds != null && isbnCode != null && isbnCode.length() > 0 )
        {
            try ( Transaction tx = gds.beginTx() )
            {
                Label booksLabel = DynamicLabel.label( "Books" );
                ResourceIterable<Node> books = gds.findNodesByLabelAndProperty( booksLabel, "isbnCode", isbnCode );
                if ( books != null && books.iterator().hasNext() )
                {
                    for ( Node bookNode : books )
                    {
                        book = new Book();
                        book.setTitle( bookNode.getProperty( "title" ).toString() );
                        book.setIsbnCode( bookNode.getProperty( "isbnCode" ).toString() );
                        book.setAuthor( bookNode.getProperty( "author" ).toString() );
                        book.setPublishedYear( bookNode.getProperty( "publishedYear" ).toString() );
                        Object p = bookNode.getProperty( "price" );
                        book.setPrice( p instanceof Double ? ( (Double) p ).doubleValue() : 0.0 );
                        break;
                    }
                }
            }
        }
        return book;
    }

    public static boolean bookExists( GraphDatabaseService gds, String isbnCode )
    {
        boolean verdict = false;

        if ( gds != null && isbnCode != null && isbnCode.length() > 0 )
        {
            try ( Transaction tx = gds.beginTx() )
            {
                Label booksLabel = DynamicLabel.label( "Books" );
                ResourceIterable<Node> books = gds.findNodesByLabelAndProperty( booksLabel, "isbnCode", isbnCode );
                verdict = books != null && books.iterator().hasNext() ? true : false;
            }
        }
        return verdict;
    }
}
