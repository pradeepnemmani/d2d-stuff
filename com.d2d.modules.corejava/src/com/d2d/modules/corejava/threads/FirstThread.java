package com.d2d.modules.corejava.threads;

public class FirstThread
{

    public static void main( String[] args )
    {
        Thread currentThread = Thread.currentThread();
        System.out.println( "Current Thread Name : " + currentThread.getName() );
        System.out.println( "Current Thread Priority : "
                + currentThread.getPriority() );
        System.out.println( "Is Current Thread a Daemon Thread : "
                + currentThread.isDaemon() );
        System.out.println( "Is Current Thread Alive : "
                + currentThread.isAlive() );
        System.out.println( "Current Thread State : "
                + currentThread.getState() );

        // Create the DisplayMessageRunnable object which is a Runnable
        Runnable r = new DisplayMessageRunnable();
        Thread thread = new Thread( r, "DISPLAY MESSAGE THREAD" );
        thread.setPriority( Thread.MAX_PRIORITY );
        // thread.setDaemon( true );

        System.out.println( "State of the display message thread : "
                + thread.getState() );
        System.out.println( "Starting the display message thread..." );
        thread.start();
        System.out.println( "Display message thread state : "
                + thread.getState() );
        System.out.println( "Returning from the main method..." );

        // Create the first thread which loops for 100 times and prints
        // the details in the fashion T1 - 0, T1 - 1, etc
        Thread t1 = new Thread( new Runnable()
        {
            @Override
            public void run()
            {
                for ( int inx = 0; inx < 100; inx++ )
                {
                    System.out.println( "T1 - " + inx );
                }
            }
        } );

        // Create the second thread which loops for 100 times and prints
        // the details in the fashion T2 - 0, T2 - 1, etc
        Thread t2 = new Thread( new Runnable()
        {
            @Override
            public void run()
            {
                for ( int inx = 0; inx < 100; inx++ )
                {
                    System.out.println( "T2 - " + inx );
                }
            }
        } );

        // Start both the threads
        t1.start();
        t2.start();
    }

}
