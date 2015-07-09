package com.d2d.modules.corejava.threads.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestCachedThreadPoolExecutor
{

    public static void main( String[] args )
    {
        ThreadPoolExecutor es = null;
        try
        {
            es = (ThreadPoolExecutor) Executors.newFixedThreadPool( 5 );
            for ( int inx = 0; inx < 25; inx++ )
            {
                TaskRunnable tr = new TaskRunnable();
                es.execute( tr );
                System.out.println( "------------------------------" );
                System.out.println( "Count of active threads : "
                        + es.getActiveCount() );
                System.out.println( "Core Pool Size : " + es.getCorePoolSize() );
                System.out.println( "Maximum Pool Size : "
                        + es.getMaximumPoolSize() );
                System.out.println( "Completed Task Count : "
                        + es.getCompletedTaskCount() );
                System.out.println( "Keep Alive Time : "
                        + es.getKeepAliveTime( TimeUnit.SECONDS ) );
                System.out.println( "------------------------------" );
            }
        }
        finally
        {
            if ( es != null )
            {
                System.out.println( "Before shutdown...." );
                es.shutdown();
                System.out.println( "After shutdown...." );
            }
        }
    }

    private static class TaskRunnable implements Runnable
    {
        @Override
        public void run()
        {
            Thread currentThread = Thread.currentThread();
            System.out.println( "Started the execution of the thread - "
                    + currentThread.getName() );
            // sleep for 5 seconds
            try
            {
                TimeUnit.SECONDS.sleep( 5 );
            }
            catch ( InterruptedException e )
            {
                System.out.println( "Interrupted : " + e.getMessage() );
            }
            System.out.println( "Return from the thread - "
                    + currentThread.getName() );
        }
    }
}
