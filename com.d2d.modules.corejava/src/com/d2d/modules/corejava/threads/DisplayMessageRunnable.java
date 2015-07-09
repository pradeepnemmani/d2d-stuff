package com.d2d.modules.corejava.threads;

import java.util.concurrent.TimeUnit;

public class DisplayMessageRunnable implements Runnable
{

    @Override
    public void run()
    {
        Thread currentThread = Thread.currentThread();
        System.out.println( "Inside the thread whose name is : "
                + currentThread.getName() );
        System.out.println( "Display message runnable thread's priority : "
                + currentThread.getPriority() );
        System.out
                .println( "Display message runnable thread is a daemon thread : "
                        + currentThread.isDaemon() );
        System.out.println( "Hello!!! from the thread..." );

        try
        {
            System.out.println( "Going to bed........." );
            TimeUnit.SECONDS.sleep( 1 );
            // Thread.sleep( 60 * 60 * 10000 );
            System.out.println( "Yaaawwwwn!!!! Woke up just now........." );
            System.out.println( "Display message runnable thread state : "
                    + currentThread.getState() );
        }
        catch ( InterruptedException e )
        {
        }
    }

}
