package com.d2d.modules.corejava.threads.executors.callable;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestFileReaderCallable
{
    private File inputFile = null;

    public TestFileReaderCallable( File inputFile )
    {
        this.inputFile = inputFile;
    }

    public Future<StringBuffer> startProcess() throws Exception
    {
        ExecutorService es = Executors.newFixedThreadPool( 1 );
        Future<StringBuffer> futureTask = null;
        try
        {
            FileReaderCallable callable = new FileReaderCallable( inputFile );
            futureTask = es.submit( callable );
        }
        finally
        {
            es.shutdown();
        }
        return futureTask;
    }

    public static void main( String[] args ) throws Exception
    {
        if ( args.length != 1 )
        {
            System.err
                    .println( "Invalid number of arguments specified. Specify an input file." );
            return;
        }

        File inputFile = new File( args[0] );
        if ( !inputFile.isFile() )
        {
            System.err
                    .println( "Specified input is not a file. Please specify an input file." );
            return;
        }

        // Construct an object of TestFileReaderCallable

        TestFileReaderCallable testObj = new TestFileReaderCallable( inputFile );
        Future<StringBuffer> future = testObj.startProcess();
        // future.cancel( false );
        if ( future.isDone() && !future.isCancelled() )
        {
            System.out.println( "Task is done and not cancelled" );
        }
        else if ( future.isDone() && future.isCancelled() )
        {
            System.out.println( "Task is done BUT cancelled" );
        }
        else if ( !future.isDone() )
        {
            System.out.println( "Task is not completed...." );
        }
        System.out.println( "Attempting to get the data from the task..." );
        System.out.println( future.get() );
    }

}
