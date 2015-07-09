package com.d2d.modules.corejava.threads;

import java.lang.Thread.UncaughtExceptionHandler;

public class D2DUncaughtExceptionHandler implements UncaughtExceptionHandler
{

    @Override
    public void uncaughtException( Thread t, Throwable e )
    {
        System.out.println( "Thread (" + t.getName()
                + ") threw the exception with the message - " + e.getMessage() );
        System.out.println( "State of the thread : " + t.getState() );
        // Shoot out an email to the support with the exception stack trace
    }

}
