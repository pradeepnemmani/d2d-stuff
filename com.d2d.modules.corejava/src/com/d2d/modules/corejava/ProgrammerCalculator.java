package com.d2d.modules.corejava;

public class ProgrammerCalculator extends Calculator
{
    public ProgrammerCalculator()
    {
        System.out
                .println( "Inside default constructor of ProgrammerCalculator()" );
    }

    public ProgrammerCalculator( String title )
    {
        System.out
                .println( "Inside parameterized constructor of ProgrammerCalculator()" );
    }

    public void toHexadecimal( int decimal )
    {
        System.out.println( "Inside toHexadecimal()" );
    }

    public void toOctal( int decimal )
    {
        System.out.println( "Inside toOctal()" );
    }

    public static void main( String[] args )
    {
        ProgrammerCalculator calc = new ProgrammerCalculator();
        int additionResult = calc.add( 25, 32 );
        System.out.println( "Programmer Calculator : Addition of 2 numbers : "
                + additionResult );

        calc.toHexadecimal( 12 );
        calc.toOctal( 12 );
    }
}
