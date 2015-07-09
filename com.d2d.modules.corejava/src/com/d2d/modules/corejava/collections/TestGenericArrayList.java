package com.d2d.modules.corejava.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class TestGenericArrayList
{

    public static void main( String[] args )
    {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add( "Some String" );
        stringArrayList.add( "Another String" );
        stringArrayList.add( "123" );
        stringArrayList.add( "345" );

        // Simple for loop
        System.out.println( ">>>> for-each <<<<" );
        for ( String element : stringArrayList )
        {
            System.out.println( element );
        }

        System.out.println( ">>>> Using Iterator <<<<" );
        Iterator<String> it = stringArrayList.iterator();
        while ( it.hasNext() )
        {
            String str = it.next();
            System.out.println( str );
        }
        
        System.out.println( ">>>> Using ListIterator <<<<" );
        ListIterator<String> lit = stringArrayList.listIterator();
        while ( lit.hasNext() )
        {
            String str = lit.next();
            System.out.println( str );
        }
        while ( lit.hasPrevious() )
        {
            String prevString = lit.previous();
            System.out.println( prevString );
        }

        Fruit apple = new Fruit( "Apple" );
        apple.setTaste( "Sweet" );
        apple.setColor( "Red" );
        apple.setSeedless( true );
        apple.setWeight( 125.0 );

        Fruit orange = new Fruit( "Orange" );
        orange.setTaste( "Sour" );
        orange.setColor( "Orange" );
        orange.setSeedless( false );
        orange.setWeight( 125.0 );

        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add( apple );
        fruits.add( orange );

        for ( Fruit fruit : fruits )
        {
            System.out.println( "Name : " + fruit.getName() );
            System.out.println( "Taste : " + fruit.getTaste() );
            System.out.println( "Color : " + fruit.getColor() );
            System.out.println( "Seedless : " + fruit.isSeedless() );
            System.out.println( "Weight : " + fruit.getWeight() );
        }

        for ( String var : apple )
        {
            System.out.println( var );
        }

    }

}
