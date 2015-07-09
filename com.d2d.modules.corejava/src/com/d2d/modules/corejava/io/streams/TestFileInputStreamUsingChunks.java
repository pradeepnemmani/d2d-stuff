package com.d2d.modules.corejava.io.streams;

import java.io.File;
import java.io.FileInputStream;

public class TestFileInputStreamUsingChunks
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

        try ( FileInputStream fis = new FileInputStream( inputFile ) )
        {
            int chunkSize = fis.available() > 100 ? 100 : fis.available();

            byte[] byteChunk = new byte[chunkSize];

            while ( fis.read( byteChunk ) != -1 )
            {
                System.out.print( new String( byteChunk ) );
                byteChunk = new byte[fis.available() > 100 ? 100 : fis
                        .available()];
            }
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
        }
    }
}
