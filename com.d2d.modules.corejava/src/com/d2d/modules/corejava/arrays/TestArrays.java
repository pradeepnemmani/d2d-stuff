package com.d2d.modules.corejava.arrays;

public class TestArrays
{
    public static void printNumbers( int[] numbers )
    {
        if ( numbers != null )
        {
            for ( int number : numbers )
            {
                System.out.println( number );
            }
        }
    }

    public static void printData( Object[] elements )
    {
        if ( elements != null )
        {
            for ( Object o : elements )
            {
                if ( o instanceof float[] )
                {
                    System.out.println( "This is a float array" );
                    float[] floats = (float[]) o;
                    for ( float f : floats )
                    {
                        System.out.println( f );
                    }
                }
                else
                {
                    System.out.println( "This is a normal object" );
                    System.out.println( o );
                }
            }
        }
    }

    public static void main( String[] args )
    {
        int[] numbers = new int[] { 1, 2, 3 };

        TestArrays.printNumbers( new int[] { 1, 2, 3 } );

        float[] floats = new float[] { 1.0f, 2.0f };
        Object[] o = new Object[] { 1.0f, 2.0f };
        TestArrays.printData( o );
        System.out.println( "Second invocation" );
        TestArrays.printData( new Object[] { floats } );
    }
}
