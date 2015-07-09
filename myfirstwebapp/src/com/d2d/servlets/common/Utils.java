package com.d2d.servlets.common;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.neo4j.graphdb.GraphDatabaseService;

import com.d2d.servlets.listeners.D2DServletContextListener;

public final class Utils
{
    public static final String SESSION_ID = "authToken";

    private Utils()
    {
        // Don't allow anybody to create objects of this class.
    }

    /**
     * For the given request, this method retrieves all the cookies. From the list of cookies, the session cookie is
     * retrieved. If there is no cookie whose name is sessionId, this method returns null.
     * 
     * @param request
     * @return Cookie if sessionId cookie exists else returns null
     */
    public static Cookie retrieveSessionCookie( HttpServletRequest request )
    {
        Cookie sessionCookie = null;

        if ( request != null )
        {
            Cookie[] cookies = request.getCookies();
            if ( cookies != null && cookies.length > 0 )
            {
                for ( Cookie cookie : cookies )
                {
                    String cName = cookie.getName();
                    if ( cName != null && cName.length() > 0 && cName.equals( Utils.SESSION_ID ) )
                    {
                        sessionCookie = cookie;
                        break;
                    }
                }
            }

        }
        return sessionCookie;
    }

    public static boolean isUserLoggedIn( HttpServletRequest request )
    {
        return request.getSession( false ) != null ? true : false;
        /*
        Cookie c = Utils.retrieveSessionCookie( request );
        return c != null ? true : false;
        */
    }

    /**
     * @param sc
     * @return Returns GraphDatabaseService object or null if there is no connectivity to the database.
     */
    public static GraphDatabaseService getGraphDatabase( ServletContext sc )
    {
        GraphDatabaseService gds = null;

        Object value = sc.getAttribute( D2DServletContextListener.KEY_GRAPH_DATABASE );
        if ( value instanceof GraphDatabaseService )
        {
            gds = (GraphDatabaseService) value;
        }
        return gds;
    }
}
