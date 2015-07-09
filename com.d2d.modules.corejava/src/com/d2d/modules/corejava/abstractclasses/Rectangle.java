package com.d2d.modules.corejava.abstractclasses;

public class Rectangle extends AbstractShape
{
    private double horizontalSide;

    private double verticalSide;

    public Rectangle()
    {
    }

    public Rectangle( double horizontalSide, double verticalSide )
    {
        super();
        this.horizontalSide = horizontalSide;
        this.verticalSide = verticalSide;
    }

    @Override
    public double calculateArea()
    {
        return horizontalSide * verticalSide;
    }

    @Override
    public void rotate( double angleInDegrees )
    {
        System.out.println( "Rotating rectangle by " + angleInDegrees + " degrees." );
    }

    @Override
    public void draw()
    {
        System.out.println( "------------" );
        System.out.println( "|          |" );
        System.out.println( "|          |" );
        System.out.println( "-----------" );
    }

}
