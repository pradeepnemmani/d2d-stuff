package com.d2d.modules.corejava.io.charstreams;

import java.io.File;
import java.io.FileReader;

public class TestFileReaderInChunks
{

    public static void main( String[] args )
    {
        if ( args.length != 1 )
        {
            System.out.println( "Please specify an input file." );
            return;
        }

        File inputFile = new File( args[0] );
        if ( !inputFile.isFile() )
        {
            System.out
                    .println( "Specified input is not a file. Please specify a file." );
            return;
        }

        try ( FileReader fr = new FileReader( inputFile ) )
        {
            // Read in chunks of 20 characters

            char[] chunks = new char[100];

            int numCharsRead = 0;
            while ( ( numCharsRead = fr.read( chunks ) ) != -1 )
            {
                if ( numCharsRead != 100 )
                {
                    char[] c = new char[numCharsRead];
                    for ( int inx = 0; inx < numCharsRead; inx++ )
                    {
                        c[inx] = chunks[inx];
                    }
                    System.out.print( String.valueOf( c ) );
                }
                else
                {
                    System.out.print( String.valueOf( chunks ) );
                }
                chunks = new char[100];
            }
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
        }
    }
}
