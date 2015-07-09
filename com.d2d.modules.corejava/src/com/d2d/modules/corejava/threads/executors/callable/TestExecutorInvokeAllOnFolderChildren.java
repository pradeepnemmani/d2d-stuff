package com.d2d.modules.corejava.threads.executors.callable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class TestExecutorInvokeAllOnFolderChildren
{
    private File inputFile = null;
    private ExecutorService es = null;

    public TestExecutorInvokeAllOnFolderChildren( File inputFile )
    {
        this.inputFile = inputFile;
        es = Executors.newFixedThreadPool( 3 );
        Runtime.getRuntime().addShutdownHook( new Thread()
        {
            @Override
            public void run()
            {
                System.out.println( "Shutdown hook called>>>>>>>>>>" );
                if ( es != null )
                {
                    es.shutdown();
                }
            }
        } );
    }

    public File getInputFile()
    {
        return inputFile;
    }

    public void setInputFile( File inputFile )
    {
        this.inputFile = inputFile;
    }

    public void collectFileReaderTasks( File folder,
            List<FileReaderCallable> tasks )
    {
        if ( tasks == null )
        {
            tasks = new ArrayList<>();
        }
        if ( folder.isDirectory() )
        {
            // Get the children
            File[] children = folder.listFiles();
            if ( children != null && children.length > 0 )
            {
                for ( File child : children )
                {
                    collectFileReaderTasks( child, tasks );
                }
            }
        }
        else if ( folder.isFile() )
        {
            FileReaderCallable task = new FileReaderCallable( folder );
            tasks.add( task );
        }
    }

    public List<Future<StringBuffer>> startProcess() throws Exception
    {
        List<FileReaderCallable> tasks = new ArrayList<>();
        collectFileReaderTasks( getInputFile(), tasks );
        // Need to submit the tasks
        List<Future<StringBuffer>> futureTasks = es.invokeAll( tasks );
        return futureTasks;
    }

    public void monitorAndPrintOutput( List<Future<StringBuffer>> futureTasks )
            throws Exception
    {
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) es;
        do
        {
            for ( Future<StringBuffer> futureTask : futureTasks )
            {
                if ( !futureTask.isDone() )
                {
                    System.err.println( "Future task : " + futureTask
                            + " is still pending completion..." );
                }
                else if ( futureTask.isCancelled() )
                {
                    System.out.println( "Future task : " + futureTask
                            + " is cancelled..." );
                }
                else
                {
                    System.out.println( futureTask.get().toString() );
                }
            }
        }
        while ( tpe.getCompletedTaskCount() < futureTasks.size() );

        if ( es != null )
        {
            es.shutdown();
        }
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
        TestExecutorInvokeAllOnFolderChildren testObj = new TestExecutorInvokeAllOnFolderChildren(
                inputFile );

        List<FileReaderCallable> inputTasks = new ArrayList<>();
        testObj.collectFileReaderTasks( testObj.getInputFile(), inputTasks  );
        StringBuffer fileContent = testObj.es.invokeAny( inputTasks );
        System.out.println(fileContent);
        
        testObj.es.shutdown();
        
        // List<Future<StringBuffer>> futureTasks = testObj.startProcess();
        // testObj.monitorAndPrintOutput( futureTasks );
    }
}
