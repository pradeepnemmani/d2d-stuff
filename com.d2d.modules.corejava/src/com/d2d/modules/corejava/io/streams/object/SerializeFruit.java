package com.d2d.modules.corejava.io.streams.object;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeFruit
{

    public static void main( String[] args )
    {
        // Algoritm
        // 1. The output file location should be provided as an input
        // to the program
        // 2. If the output file is not specified, display message and return
        // 3. Create an ObjectOutputStream for the specified output file
        // 4. Construct the fruit object and serialize (write) the fruit object
        // to the specified output file
        // 5. Close the stream

        if ( args.length != 1 )
        {
            System.out.println( "Please specify the output file." );
            return;
        }

        String outputFile = args[0];
        try ( ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream( outputFile ) ) )
        {
            Fruit fruit = new Fruit( "Apple", EnumTaste.SWEET, EnumColor.RED );
            fruit.setWeight( 125.0 );
            fruit.setSeedless( true );
            oos.writeObject( fruit );
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
