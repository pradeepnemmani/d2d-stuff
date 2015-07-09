package com.d2d.modules.corejava;

public class ScientificCalculator extends ProgrammerCalculator
{
    public ScientificCalculator()
    {
        System.out
                .println( "Inside default constructor of ScientificCalculator()" );
    }

    public ScientificCalculator( String title )
    {
        System.out
                .println( "Inside parameterized constructor of ScientificCalculator" );
    }
    
    public void sin( int number )
    {
        System.out.println( "Inside sin()" );
    }

    public void cos( int number )
    {
        System.out.println( "Inside cos()" );
    }

    public static void main( String[] args )
    {
        ScientificCalculator calc = new ScientificCalculator(
                "Scientific Calculator" );

        // Upcasting!!!
        Object calc2 = calc;

        if ( calc2 instanceof Calculator )
        {
            // Downcasting!!!
            Calculator calc3 = (Calculator) calc2;
            System.out.println( "Typecasted calculator : addition result : "
                    + calc3.add( 100, 234 ) );
        }

        System.out.println( "Result after addition of 2 numbers : "
                + calc.add( 12.4f, 12.3f ) );

        calc.sin( 12 );
        calc.cos( 12 );

        boolean verdict = calc instanceof ScientificCalculator ? true : false;
        System.out.println( "calc is an instanceof ScientificCalculator : "
                + verdict );

        verdict = calc instanceof Calculator ? true : false;
        System.out.println( "calc is an instanceof Calculator : " + verdict );

        verdict = calc instanceof Object ? true : false;
        System.out.println( "calc is an instanceof Object : " + verdict );

    }
}
