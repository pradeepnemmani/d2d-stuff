package com.d2d.modules.corejava.exceptions;

public class Calculator
{

    public Calculator()
    {
    }

    public int add( int op1, int op2 )
    {
        return op1 + op2;
    }

    public int divide( int numerator, int denominator )
            throws Exception
    {
        if ( denominator == 0 )
        {
            throw new InvalidInputException( "Denominator cannot be 0" );
        }
        return numerator / denominator;
    }
}
