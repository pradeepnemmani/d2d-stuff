package com.d2d.modules.corejava.threads.producerconsumer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestProducerConsumer
{
    private static Random random = new Random();

    public static void main( String[] args )
    {
        final SamsungInventory si = new SamsungInventory();

        Runnable producerRunnable = new Runnable()
        {
            @Override
            public void run()
            {
                while ( true )
                {
                    try
                    {
                        TimeUnit.SECONDS.sleep( random.nextInt( 4 ) );
                    }
                    catch ( InterruptedException e )
                    {
                    }
                    si.produce();
                }
            }
        };

        Runnable consumerRunnable = new Runnable()
        {
            @Override
            public void run()
            {
                while ( true )
                {
                    try
                    {
                        TimeUnit.SECONDS.sleep( random.nextInt( 4 ) );
                    }
                    catch ( InterruptedException e )
                    {
                    }
                    si.consume();
                }
            }
        };

        Thread producerThread = new Thread( producerRunnable );
        Thread consumerThread = new Thread( consumerRunnable );

        producerThread.start();
        consumerThread.start();
    }

}
