package com.d2d.modules.corejava.exceptions;

import java.sql.SQLException;

public class ControlJumpInExceptions
{
    public double retrieveBalance( String accountNo ) throws SQLException
    {
        System.out.println( "Entering retrieveBalance(..)" );
        // Write a database query to retrieve the current balance
        // for the specified accountNo
        double currentBalance = 0.0;

        boolean thingsGoFine = true;
        // Query : SELECT balance FROM accounts WHERE accountNo=...
        if ( thingsGoFine )
        {
            System.out.println( "Things went fine...." );
            currentBalance = 25000.00;
        }
        else
        {
            System.out.println( "Throwing SQLException(..)" );
            throw new SQLException( "Syntax problem in your query" );
        }

        System.out.println( "Returning from retrieveBalance(..)" );
        return currentBalance;
    }

    public boolean establishDatabaseConnection() throws DatabaseException
    {
        System.out.println( "Entering establishDatabaseConnection(..)" );
        // Do some jugglery here to establish database connection
        boolean databaseConnection = false;

        if ( !databaseConnection )
        {
            System.out.println( "Throwing DatabaseException(..)" );
            throw new DatabaseException(
                    "There was a problem with database connectivity. Please try after sometime" );
        }
        System.out.println( "Returning from establishDatabaseConnection(..)" );
        return databaseConnection;
    }

    public void withdraw( String accountNo, double amtToWithdraw )
            throws InvalidInputException, DatabaseException, SQLException,
            InsufficientFundsException
    {
        System.out.println( "Entering withdraw(..)" );
        if ( accountNo != null && accountNo.length() > 0 && amtToWithdraw > 0 )
        {
            // Valid input
            establishDatabaseConnection();
            // Control comes to the below line, it implies that we were
            // able to successfully connect to the database
            System.out.println( "Established Database Connection...." );
            // Retrieve the balance.
            double balance = retrieveBalance( accountNo );
            if ( balance < amtToWithdraw )
            {
                // Insufficient funds
                System.out.println( "Throwing InsufficientFundsException(..)" );
                throw new InsufficientFundsException( amtToWithdraw, balance );
            }
            System.out.println( "Everything is fine.... Withdrawing NOW!!!" );
            // If the control comes to this point, it implies that
            // we can proceed with the withdrawal
            // Withdraw and return
        }
        else
        {
            // Invalid input situation.
            System.out.println( "Throwing InvalidInputException(..)" );
            throw new InvalidInputException(
                    "Either the accountNo or amtToWithdraw are specified incorrectly..." );
        }
        System.out.println( "Returning from withdraw(..)" );
    }

    public static void main( String[] args ) throws Exception
    {
        ControlJumpInExceptions obj = new ControlJumpInExceptions();
        try
        {
            int numberOfAttempts = 0;
            boolean success = false;
            while ( numberOfAttempts < 3 && !success )
            {
                try
                {
                    obj = null;
                    obj.withdraw( "123", 123456 );
                    success = true;
                }
                catch ( DatabaseException de )
                {
                    numberOfAttempts++;
                    System.out.println( "Retrying...." );
                }
            }
        }
//        catch ( InvalidInputException | SQLException
//                | InsufficientFundsException e )
//        {
//            e.printStackTrace();
//        }
//        catch ( Exception e )
//        {
//            if ( e instanceof RuntimeException )
//            {
//                throw e;
//            }
//            System.out.println( e.getMessage() );
//            e.printStackTrace();
//        }
        finally
        {
            System.out.println( "Returning from main()" );
        }
    }
}
