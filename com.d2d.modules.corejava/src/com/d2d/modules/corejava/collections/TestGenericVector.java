package com.d2d.modules.corejava.collections;

import java.util.Vector;

public class TestGenericVector
{

    public static void main( String[] args )
    {
        Vector<String> strings = new Vector<>();

        String s1 = new String( "123" );
        String s2 = new String( "234" );
        String s3 = new String( "345" );
        strings.add( s1 );
        strings.add( s2 );
        strings.add( s3 );
        strings.add( s3 );
        strings.add( s3 );
        strings.add( s3 );
        strings.add( s3 );
        strings.add( s3 );
        strings.add( s3 );

        for ( String str : strings )
        {
            System.out.println( str );
        }

    }

}
