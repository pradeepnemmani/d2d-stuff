package com.d2d.modules.corejava.threads.executors.callable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class TestFolderChildrenReaderCallable
{
    private File inputFile = null;
    private ExecutorService es = Executors.newFixedThreadPool( 3 );

    public TestFolderChildrenReaderCallable( File inputFile )
    {
        this.inputFile = inputFile;
    }

    public File getInputFile()
    {
        return inputFile;
    }

    public void setInputFile( File inputFile )
    {
        this.inputFile = inputFile;
    }

    public void startProcess( File folder,
            List<Future<StringBuffer>> listOfFutureTasks ) throws Exception
    {
        if ( listOfFutureTasks == null )
        {
            throw new Exception( "List cannot be null." );
        }
        if ( folder.isDirectory() )
        {
            // Get the children
            File[] children = folder.listFiles();
            if ( children != null && children.length > 0 )
            {
                for ( File child : children )
                {
                    startProcess( child, listOfFutureTasks );
                }
            }
        }
        else if ( folder.isFile() )
        {
            FileReaderCallable callable = new FileReaderCallable( folder );
            Future<StringBuffer> futureTask = es.submit( callable );
            listOfFutureTasks.add( futureTask );
        }
    }

    public void shutdown()
    {
        if ( es != null )
        {
            es.shutdown();
        }
    }

    public ThreadPoolExecutor getExecutorService()
    {
        return (ThreadPoolExecutor) es;
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
        if ( !inputFile.isDirectory() )
        {
            System.err
                    .println( "Specified input is not a directory. Please specify a directory as an input." );
            return;
        }

        // Construct an object of TestFileReaderCallable

        TestFolderChildrenReaderCallable testObj = new TestFolderChildrenReaderCallable(
                inputFile );
        List<Future<StringBuffer>> inputList = new ArrayList<>();
        testObj.startProcess( testObj.getInputFile(), inputList );

        do
        {
            for ( Future<StringBuffer> futureTask : inputList )
            {
                if ( futureTask.isDone() && !futureTask.isCancelled() )
                {
                    System.out.println( futureTask.get() );
                }
                else if ( futureTask.isDone() && futureTask.isCancelled() )
                {
                    System.out.println( "This task is cancelled...." );
                }
                else if ( !futureTask.isDone() )
                {
                    System.out
                            .println( futureTask + " is still in progress..." );
                }
            }
        }
        while ( testObj.getExecutorService().getCompletedTaskCount() < inputList
                .size() );

        testObj.shutdown();
    }
}
