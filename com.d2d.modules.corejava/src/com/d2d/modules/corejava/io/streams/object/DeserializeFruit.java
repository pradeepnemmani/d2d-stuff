package com.d2d.modules.corejava.io.streams.object;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeFruit
{

    public static void main( String[] args )
    {
        // 1. Process the arguments and ensure that the input file is specified
        // i.e. number of arguments should be 1.
        // 2. If the number of arguments is not 1, display message and return
        // 3. If the specified input file is NOT a file, display message and
        // return
        // 4. Create the ObjectInputStream for the specified input file
        // 5. Read the object via readObject() method
        // 6. On the return object, check if it is an instance of Fruit,
        // typecast to fruit
        // 7. Print the details about the fruit
        // 8. Close the stream

        if ( args.length != 1 )
        {
            System.out.println( "Please specify an input file." );
            return;
        }

        File inputFile = new File( args[0] );
        if ( !inputFile.isFile() )
        {
            System.out
                    .println( "Specified input is NOT a file. Please specify a file and not a folder" );
            return;
        }

        try ( ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream( inputFile ) ) )
        {
            Object objectRead = ois.readObject();
            if ( objectRead instanceof Fruit )
            {
                Fruit fruit = (Fruit) objectRead;
                DeserializeFruit.printFruitDetails( fruit );
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
        catch ( ClassNotFoundException cnfe )
        {
            cnfe.printStackTrace();
        }
    }

    private static void printFruitDetails( Fruit fruit )
    {
        System.out.println( "Name : " + fruit.getName() );
        System.out.println( "Color : " + fruit.getColor().name() );
        System.out.println( "Taste : " + fruit.getTaste().name() );
        System.out.println( "Weight : " + fruit.getWeight() );
        System.out.println( "Is Seedless : " + fruit.isSeedless() );
    }
}
