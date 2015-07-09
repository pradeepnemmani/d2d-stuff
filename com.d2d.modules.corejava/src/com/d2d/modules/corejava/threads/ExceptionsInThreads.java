package com.d2d.modules.corejava.threads;

public class ExceptionsInThreads
{

    public static void main( String[] args )
    {
        MyRunnable runnable = new MyRunnable( null );
        Thread thread = new Thread( runnable, "Uncaught Exception Thread" );
        thread.setUncaughtExceptionHandler( new D2DUncaughtExceptionHandler() );
        thread.start();
    }

    private static class MyRunnable implements Runnable
    {
        private Object data;

        public MyRunnable( Object obj )
        {
            data = obj;
        }

        @Override
        public void run()
        {
            System.out.println( "Input : " + data.toString() );
            System.out.println( "Return from the thread..." );
        }
    }

}
