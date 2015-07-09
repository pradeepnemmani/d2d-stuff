package com.d2d.modules.corejava;

public class Parent
{
    public Parent()
    {
        displayMessage();
    }

    public void displayMessage()
    {
        System.out.println( "Parent..." );
    }

    public void displayMessage( String message )
    {
        System.out.println( message );
    }
    
    public void displayMessage( Object obj )
    {
        System.out.println( obj.toString() );
    }
    
//    public int displayMessage( String message )
//    {
//        System.out.println( message );
//        return 1;
//    }
    
    public int add( int op1, int op2 )
    {
        return op1 + op2;
    }
    
    public int add( float op1, int op2 )
    {
        return ((int)op1) + op2;
    }
    
    public static void main(String[] args)
    {
        Parent p = new Parent();
        p.add( 1, 2 );
//        System.out.println( "Result : " + result );
    }
}
