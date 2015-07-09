package com.d2d.modules.corejava.threads.factory;

import java.util.concurrent.TimeUnit;

public class TestSubclassedThread
{

    public static void main( String[] args )
    {

        Runnable r = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println( "Sleeping for 5 seconds..." );
                try
                {
                    TimeUnit.SECONDS.sleep( 5 );
                }
                catch ( InterruptedException e )
                {
                    e.printStackTrace();
                }
                System.out.println( "After waking up..." );
            }
        };

        D2DThreadFactory factory = new D2DThreadFactory();
        SyncAsyncThread t = factory.newThread( r, false );
        t.start();
        System.out.println( "Returning from main..." );
    }

}
