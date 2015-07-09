package com.d2d.modules.corejava.threads;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SameRunnableMultipleThreads
{

    public static void main( String[] args )
    {
        EntryAndReturnTimeRunnable runnable = new EntryAndReturnTimeRunnable();

        for ( int inx = 0; inx < 30; inx++ )
        {
            Thread t = new Thread( runnable, "Thread - " + inx );
            t.start();
        }
    }

    private static class EntryAndReturnTimeRunnable implements Runnable
    {
        private ThreadLocal<Date> returnTimeLocal;
//        private Date returnTime;

        @Override
        public void run()
        {
//             returnTime = new Date( System.currentTimeMillis() );
            returnTimeLocal = new ThreadLocal<Date>()
            {

                @Override
                protected Date initialValue()
                {
                    return new Date( System.currentTimeMillis() );
                }

            };

            Thread currentThread = Thread.currentThread();
            // returnTime = new Date( System.currentTimeMillis() );
            SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm:ss.SSS" );
            System.out.println( currentThread.getName() + "'s Return time : "
                    + sdf.format( returnTimeLocal.get() ) );
        }
    }

}
