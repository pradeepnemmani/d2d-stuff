package com.d2d.modules.corejava.threads;

public class TestJoins
{

    public static void main( String[] args )
    {
        Runnable r1 = new Runnable()
        {
            @Override
            public void run()
            {
                Thread currentThread = Thread.currentThread();

                for ( int inx = 0; inx < 1000000; inx++ )
                {

                }
                System.out
                        .println( "RETURNING FROM " + currentThread.getName() );
            }
        };

        Runnable r2 = new Runnable()
        {
            @Override
            public void run()
            {
                Thread currentThread = Thread.currentThread();

                for ( int inx = 0; inx < 1000; inx++ )
                {

                }
                System.out
                        .println( "RETURNING FROM " + currentThread.getName() );
            }
        };

        System.out.println( "My Thread Name : "
                + Thread.currentThread().getName() );
        Thread t1 = new Thread( r1, "Long Running Job" );
        Thread t2 = new Thread( r2, "Short Running Job" );

        System.out.println( "Starting both the threads..." );
        t1.start();
        t2.start();
        System.out
                .println( "Joining with both the threads i.e. finalization of both the threads..." );
        try
        {
            System.out.println( "Before t1.join()" );
            t1.join();
            System.out.println( "After t1.join()" );
            System.out.println( "Before t2.join()" );
            t2.join();
            System.out.println( "After t2.join()" );
        }
        catch ( InterruptedException e )
        {
            System.out.println( "I have been interrupted..." + e.getMessage() );
        }
        System.out.println( "Returning from main()...." );

    }
}
