package com.d2d.modules.corejava.io.streams.object;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeFruitBox
{

    public static void main( String[] args )
    {
        if ( args.length != 1 )
        {
            System.out.println( "Specify output file." );
            return;
        }

        try ( ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream( args[0] ) ) )
        {
            // Create a box of fruits.
            Box fruitBox = new Box();
            Fruit apple = new Fruit( "Apple", EnumTaste.SWEET, EnumColor.GREEN );
            apple.setWeight( 120.00 );
            apple.setSeedless( false );
            Fruit orange = new Fruit( "Orange", EnumTaste.SOUR,
                    EnumColor.ORANGE );
            orange.setWeight( 150.00 );
            orange.setSeedless( true );
            // Add the fruits
            fruitBox.addFruit( apple );
            fruitBox.addFruit( orange );

            // Serialize the box to the output file
            oos.writeObject( fruitBox );
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
