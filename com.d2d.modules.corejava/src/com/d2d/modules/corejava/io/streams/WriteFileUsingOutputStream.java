package com.d2d.modules.corejava.io.streams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileUsingOutputStream
{

    public static void main( String[] args ) throws Exception
    {
        String tempLocation = System.getenv( "TEMP" );
        String fileName = tempLocation + File.separator + "first-file.txt";

        FileOutputStream fos = null;
        try
        {
            fos = new FileOutputStream( fileName );
            String s = "Hello";
            byte[] bytes = s.getBytes();
            for ( byte b : bytes )
            {
                fos.write( b );
            }
        }
        catch ( FileNotFoundException fnfe )
        {
            fnfe.printStackTrace();
            throw fnfe;
        }
        catch ( IOException ioe )
        {
            ioe.printStackTrace();
            throw ioe;
        }
        finally
        {
            try
            {
                if ( fos != null )
                {
                    fos.close();
                }
            }
            catch ( Exception ex )
            {
                System.out.println( "Unable to close the stream" );
            }
        }

    }

}
