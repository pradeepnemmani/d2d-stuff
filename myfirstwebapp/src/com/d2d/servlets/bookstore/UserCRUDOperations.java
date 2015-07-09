package com.d2d.servlets.bookstore;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterable;
import org.neo4j.graphdb.Transaction;

import com.d2d.servlets.model.User;

public class UserCRUDOperations
{
    private UserCRUDOperations()
    {
        // Private constructor
    }

    public static User createUser( GraphDatabaseService gds, User user )
    {
        if ( gds != null && user != null && user.getEmail() != null && user.getEmail().length() > 0
                && user.getPassword() != null && user.getPassword().length() > 0 )
        {
            try ( Transaction tx = gds.beginTx(); )
            {
                Label users = DynamicLabel.label( "Users" );
                Node userNode = gds.createNode( users );
                userNode.setProperty( "email", user.getEmail() );
                // NOTE: Password should not be saved to the database
                // as plain text but should be encoded & saved
                userNode.setProperty( "password", user.getPassword() );
                userNode.setProperty( "firstName", user.getFirstName() );
                userNode.setProperty( "lastName", user.getLastName() );
                if ( user.getAge() != -1 )
                {
                    userNode.setProperty( "age", user.getAge() );
                }
                if ( user.getGender() != null )
                {
                    userNode.setProperty( "gender", user.getGender() );
                }

                tx.success();
                return user;
            }
        }
        return null;
    }

    public static boolean authenticate( GraphDatabaseService gds, String email, String password )
    {
        boolean authenticated = false;

        if ( gds != null && email != null && email.length() > 0 && password != null && password.length() > 0 )
        {
            Label usersLabel = DynamicLabel.label( "Users" );
            try ( Transaction tx = gds.beginTx() )
            {
                ResourceIterable<Node> matchedUsers = gds.findNodesByLabelAndProperty( usersLabel, "email", email );
                if ( matchedUsers != null && matchedUsers.iterator().hasNext() )
                {
                    for ( Node userNode : matchedUsers )
                    {
                        String pwsInDB = userNode.getProperty( "password" ).toString();
                        authenticated = pwsInDB.equals( password ) ? true : false;
                        break;
                    }
                }
            }
        }
        return authenticated;
    }

    public static boolean emailExists( GraphDatabaseService gds, String email )
    {
        boolean verdict = true;

        if ( gds != null && email != null && email.length() > 0 )
        {
            try ( Transaction tx = gds.beginTx() )
            {
                Label usersLabel = DynamicLabel.label( "Users" );
                ResourceIterable<Node> users = gds.findNodesByLabelAndProperty( usersLabel, "email", email );
                verdict = users != null && users.iterator().hasNext() ? true : false;
            }
        }
        return verdict;
    }
}
