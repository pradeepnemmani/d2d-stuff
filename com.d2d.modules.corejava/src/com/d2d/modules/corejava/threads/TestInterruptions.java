package com.d2d.modules.corejava.threads;

import java.util.concurrent.TimeUnit;

public class TestInterruptions
{

    public static void main( String[] args )
    {
        Runnable myRunnable = new Runnable()
        {
            @Override
            public void run()
            {
                Thread currentThread = Thread.currentThread();
                for ( int inx = 0;; inx++ )
                {
                    System.out.println( "Thread counter : " + inx );
                    if ( currentThread.isInterrupted() )
                    {
                        System.out.println( "I HAVE BEEN INTERRUPTED....." );
                        // What decision do i make?
                        // Let me break;
                        break;
                    }
                }
            }
        };

        Thread thread = new Thread( myRunnable );
        thread.start();
        System.out.println( "Returning from Main method()" );

        try
        {
            TimeUnit.SECONDS.sleep( 5 );
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
