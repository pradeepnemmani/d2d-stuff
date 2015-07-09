package com.d2d.modules.corejava.generics;

import java.util.ArrayList;
import java.util.List;

public class Box<T>
{
    private List<T> items;

    public Box()
    {
        super();
        items = new ArrayList<>();
    }

    public void addItem( T item )
    {
        items.add( item );
    }

    public T getItem( int index )
    {
        return items.get( index );
    }

    public int size()
    {
        return items.size();
    }

    /*
     * private static <T> void printBoxContents( Box<T> boxToPrint ) { // Print
     * all the items in the box for ( int inx = 0; inx < boxToPrint.size();
     * inx++ ) { System.out.println( boxToPrint.getItem( inx ) ); } }
     * 
     * private static void printBoxContents2( Box<?> box ) { // Print all the
     * items in the box for ( int inx = 0; inx < box.size(); inx++ ) {
     * System.out.println( box.getItem( inx ) ); } }
     */

    private static void printNumberBox( Box<? extends Number> numberBox )
    {
        // Print all the items in the box
        for ( int inx = 0; inx < numberBox.size(); inx++ )
        {
            System.out.println( numberBox.getItem( inx ) );
        }
        // numberBox.addItem( toAdd );
    }

    public static void main( String[] args )
    {
        Box<Integer> integersBox = new Box<>();
        for ( int inx = 0; inx < 10; inx++ )
        {
            integersBox.addItem( inx );
        }
        // Print the box contents
        // Box.printBoxContents( integersBox );
        System.out.println( "-------------------------------" );
        Box.printNumberBox( integersBox );

        Box<Double> doubleBox = new Box<>();
        doubleBox.addItem( 123.0 );
        doubleBox.addItem( 234.0 );
        doubleBox.addItem( 32453.0 );

        Box.printNumberBox( doubleBox );
        /*
         * Box<String> stringBox = new Box<>(); stringBox.addItem( "Hello");
         * stringBox.addItem( "World" ); stringBox.addItem( "Universe" );
         * stringBox.addItem( "Galaxy" );
         * 
         * System.out.println( "-------------------------------" );
         * Box.printNumberBox( stringBox );
         */
    }
}
