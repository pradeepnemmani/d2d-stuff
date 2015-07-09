package com.d2d.modules.corejava.threads.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class TestLocks
{
    private ReadLock readLock = null;

    private WriteLock writeLock = null;

    public TestLocks()
    {
        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        readLock = rwLock.readLock();
        writeLock = rwLock.writeLock();
    }

    public void writeCriticalData()
    {
        // Read some predefined critical data
        System.out.println( "Acquiring the read lock...." );
        readLock.lock();
        // This is a critical section for reading the data.
        System.out.println( "After acquiring the read lock...." );

        System.out.println( "unlocking the readlock" );
        readLock.unlock();
        // acquire the write lock

        System.out.println( "Acquiring write lock...." );
        writeLock.lock();
        // Write some data
        System.out
                .println( "Acquired write lock and now proceeding with the critical section" );
        writeLock.unlock();
    }

    public static void main( String[] args )
    {

        final TestLocks tl = new TestLocks();

        Runnable myRunnable = new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    TimeUnit.SECONDS.sleep( 1 );
                }
                catch ( InterruptedException e )
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                tl.writeCriticalData();
            }
        };

        for ( int inx = 0; inx < 10; inx++ )
        {
            Thread t = new Thread( myRunnable );
            t.start();
        }

    }

}
