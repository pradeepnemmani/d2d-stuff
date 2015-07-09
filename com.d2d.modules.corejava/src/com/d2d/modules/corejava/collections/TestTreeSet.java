package com.d2d.modules.corejava.collections;

import java.util.TreeSet;

public class TestTreeSet
{

    public static void main( String[] args )
    {
        TreeSet<String> ts = new TreeSet<>( new SortDescendingComparator() );
        ts.add( "ABC" );
        ts.add( "abc" );
        ts.add( "123" );
        ts.add( "$123" );
        ts.add( "Hello" );
        ts.add( "AABC" );

        System.out.println( "Printing the treeset details..." );
        for ( String str : ts )
        {
            System.out.println( str + " -> Hashcode : " + str.hashCode() );
        }

        // Create a treeset which holds Fruit objects
        TreeSet<Fruit> fruits = new TreeSet<>();
        Fruit f1 = new Fruit( "Apple" );
        f1.setWeight( 125 );

        Fruit f2 = new Fruit( "Orange" );
        f2.setWeight( 125 );

        Fruit f3 = new Fruit( "Banana" );
        f3.setWeight( 40 );

        Fruit f4 = new Fruit( "Plum" );
        f4.setWeight( 30 );

        Fruit f5 = new Fruit( "Fig" );
        f5.setWeight( 25 );

        Fruit f6 = new Fruit( "Pineapple" );
        f6.setWeight( 500 );

        Fruit f7 = new Fruit( "Grapes" );
        f7.setWeight( 10 );

        Fruit f8 = new Fruit( "Apple" );
        f8.setWeight( 110 );

        Fruit f9 = new Fruit( "Apple" );
        f9.setWeight( 90 );
        
        System.out.println( "Adding apple..." );
        fruits.add( f1 );
        System.out.println( "Adding Orange..." );
        fruits.add( f2 );
        fruits.add( f3 );
        fruits.add( f4 );
        fruits.add( f5 );
        fruits.add( f6 );
        fruits.add( f7 );
        fruits.add( f8 );
        fruits.add( f9 );

        System.out.println( "Displaying fruits in sorted order..." );
        for ( Fruit fruit : fruits )
        {
            System.out.println( fruit.getName() + ", Weight : "
                    + fruit.getWeight() );
        }
    }

}
