package com.d2d.modules.corejava.io.streams.data;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataOutputStream
{

    public static void main( String[] args )
    {
        // 1. As this writes the data to the file, the output file
        // should be provided as an argument to the program.
        // If the number of arguments specified is not 1, print
        // a message and return
        // 2. Create a DataOutputStream object using the specified
        // output file
        // 3. Write the data to the output stream (probably, write
        // an integer, float, double, boolean, char, string)
        // 4. Close the output stream

        if ( args.length != 1 )
        {
            System.out
                    .println( "Invalid number of arguments specified. Please specify an output file." );
            return;
        }
        // Create the DataOutputStream object
        // Create the FileOutputStream object to write to the file
        DataOutputStream dos = null;
        try
        {
            dos = new DataOutputStream( new FileOutputStream( args[0] ) );
            // Write an integer
            dos.writeInt( 112452 );
            // Write a boolean
            dos.writeBoolean( true );
            // Write a Double
            dos.writeDouble( 123.45 );
            // Write a string (which will be UTF-8 encoded)
            dos.writeUTF( "Hello World" );
        }
        catch ( FileNotFoundException fnfe )
        {
            fnfe.printStackTrace();
        }
        catch ( IOException ioe )
        {
            ioe.printStackTrace();
        }
        finally
        {
            try
            {
                if ( dos != null )
                {
                    dos.close();
                }
            }
            catch ( IOException ioe )
            {
                System.out
                        .println( "Unable to close the data output stream. Error Message : "
                                + ioe.getMessage() );
            }
        }
    }

}
