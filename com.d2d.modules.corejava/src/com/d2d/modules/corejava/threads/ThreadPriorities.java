package com.d2d.modules.corejava.threads;

public class ThreadPriorities
{

    public static void main( String[] args )
    {
        Runnable p1Runnable = new Runnable()
        {
            @Override
            public void run()
            {
                Thread currentThread = Thread.currentThread();
                for ( int inx = 0; inx < 10; inx++ )
                {
                    System.out.println( currentThread.getName() + " " + inx );
                }
            }
        };

        Runnable p10Runnable = new Runnable()
        {
            @Override
            public void run()
            {
                Thread currentThread = Thread.currentThread();
                for ( int inx = 0; inx < 10; inx++ )
                {
                    System.out.println( currentThread.getName() + " " + inx );
                }
            }
        };

        Thread p1Thread = new Thread( p1Runnable, "P1" );
        p1Thread.setPriority( Thread.MAX_PRIORITY );
        Thread p10Thread = new Thread( p10Runnable, "P10" );
        p10Thread.setPriority( Thread.MIN_PRIORITY );

        p1Thread.start();
        p10Thread.start();
    }

}
