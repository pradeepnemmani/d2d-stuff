package com.d2d.modules.corejava.generics;

public class FirstGenericClass<T>
{
    private T data;

    public T getData()
    {
        return data;
    }

    public void setData( T data )
    {
        this.data = data;
    }

    public static void main( String[] args )
    {
        FirstGenericClass<String> b = new FirstGenericClass<String>();
        b.setData( "Hello World" );
        System.out.println( b.getData() );

        // Box of integers
        FirstGenericClass<Integer> bInts = new FirstGenericClass<Integer>();
        bInts.setData( 124 );
        System.out.println( bInts.getData().intValue() );
    }
}
