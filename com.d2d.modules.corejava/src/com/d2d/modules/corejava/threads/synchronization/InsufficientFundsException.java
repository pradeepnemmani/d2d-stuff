package com.d2d.modules.corejava.threads.synchronization;

public class InsufficientFundsException extends Exception
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public InsufficientFundsException()
    {
        super( "Insufficient funds in the account." );
    }

    public InsufficientFundsException( String message )
    {
        super( message );
    }

}
