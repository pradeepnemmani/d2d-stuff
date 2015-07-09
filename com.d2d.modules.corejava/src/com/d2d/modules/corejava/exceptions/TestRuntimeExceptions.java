package com.d2d.modules.corejava.exceptions;

public class TestRuntimeExceptions
{

    public int division( int a, int b )
    {
        return a / b;
    }

    public int performDivision( int numerator, int denominator )
            throws InvalidInputException
    {
        if ( denominator != 0 )
            return numerator / denominator;

        throw new InvalidInputException(
                "Denominator specified is not valid. Please specify anything other than 0." );
    }

    public static void main( String[] args )
    {
        TestRuntimeExceptions tre = new TestRuntimeExceptions();

        try
        {
            int divisionResult = tre.performDivision( 10, 1 );
            System.out.println( "Division Result : " + divisionResult );
        } catch ( InvalidInputException e )
        {
            System.out.println( e.getMessage() );
        }
    }

}
