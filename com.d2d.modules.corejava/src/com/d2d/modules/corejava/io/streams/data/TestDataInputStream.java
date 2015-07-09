package com.d2d.modules.corejava.io.streams.data;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestDataInputStream
{

    public static void main( String[] args )
    {
        // Algo

        // 1. Retrieve the arguments for the program. There should be
        // only one argument and that should indicate the file to be
        // read.
        // If the number of arguments specified is not 1, then display
        // a message and return
        // 2. Create a DataInputStream object for the specified file
        // 3. Read the data from the datainputstream
        // 3.a) Reading should happen in the same order in which
        // the data was written i.e. if writeInt() followed by
        // writeBoolean() happened at the time of writing, reading
        // should also happen in the same sequence i.e. readInt()
        // followed by readBoolean()
        // 4. If the end of the file is reached, an exception EOFException
        // needs to be caught
        // 5. Close the resources created

        if ( args.length != 1 )
        {
            System.out
                    .println( "Invalid arguments specified. Please specify the input file name to read." );
            return;
        }

        // Verify if the specified input is truly a file
        String inputFileName = args[0];
        File inputFile = new File( inputFileName );
        if ( !inputFile.isFile() )
        {
            System.out.println( "Specified input is not a file." );
            return;
        }

        // Create a data input stream
        try ( DataInputStream dis = new DataInputStream( new FileInputStream(
                inputFileName ) ) )
        {
            // The sequence of reading should be:
            // readInt(), readBoolean(), readDouble(), readUTF()
            // Why am I saying this? Please see TestDataOutputStream
            // on the order of the data that was written
            int integer = dis.readInt();
            System.out.println( "Integer : " + integer );
            boolean b = dis.readBoolean();
            System.out.println( "Boolean value : " + b );
            double d = dis.readDouble();
            System.out.println( "Double value : " + d );
            String utfString = dis.readUTF();
            System.out.println( "String value : " + utfString );
        }
        catch ( FileNotFoundException fnfe )
        {
            fnfe.printStackTrace();
        }
        catch ( EOFException eofe )
        {
            System.out.println( "End of file reached...." );
        }
        catch ( IOException ioe )
        {
            ioe.printStackTrace();
        }
    }

}
