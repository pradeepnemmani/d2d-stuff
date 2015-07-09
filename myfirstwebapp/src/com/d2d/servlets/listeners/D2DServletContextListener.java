package com.d2d.servlets.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class D2DServletContextListener implements ServletContextListener
{
    public static final String KEY_GRAPH_DATABASE = "GraphDatabase";
    private static final String DB_LOCATION = "/opt/apps/neo4j-2.0.1/data/bookstore";

    private GraphDatabaseService graphDatabase = null;

    @Override
    public void contextDestroyed( ServletContextEvent sce )
    {
        System.out.println( "Shutting down the database...." );
        if ( graphDatabase != null )
        {
            graphDatabase.shutdown();
        }
    }

    @Override
    public void contextInitialized( ServletContextEvent sce )
    {
        System.out.println(sce.getServletContext().getServletContextName());
        System.out.println( "Initializing the database...." );
        graphDatabase = new GraphDatabaseFactory().newEmbeddedDatabase( D2DServletContextListener.DB_LOCATION );
        // Add the graphDatabase object as a attribute on the servlet context
        sce.getServletContext().setAttribute( KEY_GRAPH_DATABASE, graphDatabase );
    }

}
