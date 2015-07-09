package com.d2d.modules.corejava.threads.factory;

public class SyncAsyncThread extends Thread
{
    private boolean runInAsyncMode = true;

    public SyncAsyncThread()
    {
        super();
    }

    public SyncAsyncThread( Runnable target, String name )
    {
        super( target, name );
    }

    public SyncAsyncThread( Runnable target )
    {
        super( target );
    }

    public SyncAsyncThread( String name )
    {
        super( name );
    }

    public boolean isRunInAsyncMode()
    {
        return runInAsyncMode;
    }

    public void setRunInAsyncMode( boolean runInAsyncMode )
    {
        this.runInAsyncMode = runInAsyncMode;
    }

    @Override
    public synchronized void start()
    {
        if ( isRunInAsyncMode() )
        {
            super.start();
        }
        else
        {
            super.run();
        }
    }

}
