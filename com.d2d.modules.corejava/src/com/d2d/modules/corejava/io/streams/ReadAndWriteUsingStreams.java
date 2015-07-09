package com.d2d.modules.corejava.io.streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadAndWriteUsingStreams
{

    public static void main( String[] args )
    {
        if ( args.length != 2 )
        {
            System.out
                    .println( "Invalid number of arguments specified. Please provide the input file name and output file name." );
            return;
        }

        String inputFileName = args[0];
        String outputFileName = args[1];

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try
        {
            // Create the fileinputstream for the specified input file
            fis = new FileInputStream( inputFileName );
            // Create the fileoutput stream for the specified output file
            fos = new FileOutputStream( outputFileName );
            // Read the input file as long as the end of file is not reached.
            // Reading always happens in bytes

            int byteRead;

            while ( ( byteRead = fis.read() ) != -1 )
            {
                fos.write( byteRead );
            }
        }
        catch ( FileNotFoundException fnfe )
        {
            System.out
                    .println( "Specified file cannot be found. Error Message : "
                            + fnfe.getMessage() );
        }
        catch ( IOException ioe )
        {
            ioe.printStackTrace();
        }
        finally
        {
            try
            {
                if ( fis != null )
                {
                    fis.close();
                }
                if ( fos != null )
                {
                    fos.close();
                }
            }
            catch ( Exception ex )
            {
                System.out.println( "Unable to close the streams. Error : "
                        + ex.getMessage() );
            }
        }
    }

}
