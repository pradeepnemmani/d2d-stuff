package com.d2d.modules.corejava;

/**
 * Provides the standard calculator capabilities
 * 
 * @author chandrav
 * 
 */
public class Calculator
{
    public Calculator()
    {
        System.out.println( "Inside default constructor of Calculator()" );
    }

    /**
     * This method performs an addition on the specified inputs (i.e. integers)
     * and returns an integer.
     * 
     * @param operand1
     *            input 1
     * @param operand2
     *            input 2
     * @return integer which is the result of the addition of the specified
     *         operands
     */
    public int add( int operand1, int operand2 )
    {
        return operand1 + operand2;
    }

    /**
     * @param operand1
     * @param operand2
     * @return
     */
    public float add( float operand1, float operand2 )
    {
        return operand1 + operand2;
    }

    public int subtract( int operand1, int operand2 )
    {
        return operand1 - operand2;
    }

    public static void main( String[] args )
    {
        Calculator calc = new Calculator();

        int result = calc.add( 10, 10 );
        System.out.println( "Result after addition of 10 and 10 : " + result );

        float floatResult = calc.add( 12.5f, 11.35f );
        System.out.println( "Result after addition of 12.5 and 11.35 : "
                + floatResult );
    }
}
