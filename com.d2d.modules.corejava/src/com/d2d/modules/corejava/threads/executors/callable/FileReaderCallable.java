package com.d2d.modules.corejava.threads.executors.callable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FileReaderCallable implements Callable<StringBuffer>
{
    private File inputFile = null;

    public FileReaderCallable( File inputFile )
    {
        this.inputFile = inputFile;
    }

    @Override
    public StringBuffer call() throws Exception
    {
        System.out.println( "Inside call()" );
        StringBuffer sb = new StringBuffer();

        if ( inputFile != null )
        {
            try ( BufferedReader br = new BufferedReader( new FileReader(
                    inputFile ) ) )
            {
                String line = null;

                while ( ( line = br.readLine() ) != null )
                {
                    sb.append( line );
                    sb.append( "\n" );
                }

            }
            catch ( Exception ex )
            {
                System.err.println( "Exception encountered : "
                        + ex.getMessage() );
                throw ex;
            }

        }
        TimeUnit.SECONDS.sleep( 2 );
        return sb;
    }
}
