package com.d2d.modules.corejava.io.charstreams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestFileReader
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
            int nextCharRead;

            while ( ( nextCharRead = fr.read() ) != -1 )
            {
                System.out.print( new String(
                        new byte[] { (byte) nextCharRead } ) );
            }
        }
        catch ( FileNotFoundException fnfe )
        {
            fnfe.printStackTrace();
        }
        catch ( IOException ioe )
        {
            ioe.printStackTrace();
        }
    }

}
