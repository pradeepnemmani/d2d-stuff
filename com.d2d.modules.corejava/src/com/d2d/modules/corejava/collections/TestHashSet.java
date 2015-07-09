package com.d2d.modules.corejava.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class TestHashSet
{

    public static void main( String[] args )
    {

        HashSet<String> hashset = new HashSet<>();

        String s1 = "Hello";
        String s2 = "World";
        String s3 = "Universe";
        String s4 = "Galaxy";

        hashset.add( s1 );
        hashset.add( s2 );
        hashset.add( s3 );
        hashset.add( s4 );

        System.out.println( "Size of the hashset : " + hashset.size() );

        for ( String str : hashset )
        {
            System.out.println( str );
        }

        System.out.println( "Traditional for-loop" );
        for ( int inx = 0; inx < hashset.size(); inx++ )
        {
            // Cannot get the data using index-based/position based.
        }

        System.out.println( "Using the Iterator approach" );
        // Lists & Vector support index-based retrieval.
        // Sets do not support position/index-based retrieval.
        Iterator<String> it = hashset.iterator();
        while ( it.hasNext() )
        {
            System.out.println( it.next() );
        }

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add( s1 );
        lhs.add( s2 );
        lhs.add( s3 );
        lhs.add( s4 );

        System.out.println( "Printing data in LinkedHashSet..." );
        long startTime = System.nanoTime();
        for ( String str : lhs )
        {
            System.out.println( str );
        }
        long endTime = System.nanoTime();
        System.out.println( "Time spent in looping : " + (endTime-startTime) + " ns." );
        
    }

}
