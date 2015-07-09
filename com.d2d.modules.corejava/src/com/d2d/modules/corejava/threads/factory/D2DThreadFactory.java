package com.d2d.modules.corejava.threads.factory;

import java.util.concurrent.ThreadFactory;

public class D2DThreadFactory implements ThreadFactory
{

    @Override
    public SyncAsyncThread newThread( Runnable r )
    {
        return new SyncAsyncThread( r );
    }

    public SyncAsyncThread newThread( Runnable r, boolean asynchronousMode )
    {
        SyncAsyncThread thread = new SyncAsyncThread( r );
        thread.setRunInAsyncMode( asynchronousMode );
        return thread;
    }
}
