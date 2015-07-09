package com.d2d.modules.corejava.io.streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFileUsingInputStream
{

    public static void main( String[] args )
    {
        String tempLocation = System.getenv( "TEMP" );
        String inputFileName = tempLocation + File.separator + "first-file.txt";

        try ( FileInputStream fis = new FileInputStream( inputFileName ) )
        {
            int nextByte;
            while ( ( nextByte = fis.read() ) != -1 )
            {
                byte[] b = new byte[] { (byte) nextByte };
                System.out.print( new String( b ) );
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
