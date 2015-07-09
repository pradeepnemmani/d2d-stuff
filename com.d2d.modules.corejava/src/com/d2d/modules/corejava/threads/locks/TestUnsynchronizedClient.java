package com.d2d.modules.corejava.threads.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestUnsynchronizedClient
{

    public static void main( String[] args )
    {
        final Account account = new Account( 1000 );
        account.setAccountNumber( "123456" );

        Runnable depositRunnable = new Runnable()
        {
            @Override
            public void run()
            {
//                try
//                {
//                    TimeUnit.SECONDS.sleep( 1 );
//                }
//                catch ( InterruptedException e )
//                {
//                    e.printStackTrace();
//                }
                account.deposit( 1000 );
            }
        };

        Runnable withdrawRunnable = new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    TimeUnit.SECONDS.sleep( ( new Random() ).nextInt( 4 ) );
                    account.withdraw( 1000 );
                }
                catch ( InterruptedException e )
                {
                    e.printStackTrace();
                }
            }
        };

        // Create the threads.
        List<Thread> depositThreads = new ArrayList<>();
        for ( int inx = 0; inx < 3; inx++ )
        {
            depositThreads.add( new Thread( depositRunnable ) );
        }
        // 3 more withdrawal threads
        // List<Thread> withdrawThreads = new ArrayList<>();
        // for ( int inx = 0; inx < 3; inx++ )
        // {
        // withdrawThreads.add( new Thread( withdrawRunnable ) );
        // }
        // Start the threads
        for ( Thread threadToStart : depositThreads )
        {
            threadToStart.start();
        }

//        for ( Thread threadToStart : withdrawThreads )
//        {
//            threadToStart.start();
//        }
    }

}
