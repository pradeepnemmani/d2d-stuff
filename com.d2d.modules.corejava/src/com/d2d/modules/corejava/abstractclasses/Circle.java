package com.d2d.modules.corejava.abstractclasses;

public class Circle extends AbstractShape
{
    private double radius;

    public Circle()
    {
    }

    public Circle( double radius )
    {
        this.radius = radius;
    }

    public double getRadius()
    {
        return radius;
    }

    public void setRadius( double radius )
    {
        this.radius = radius;
    }

    @Override
    public double calculateArea()
    {
        return radius * radius * Math.PI;
    }

    @Override
    public void rotate( double angleInDegrees )
    {
        System.out.println( "Rotating Circle by " + angleInDegrees
                + " degrees." );
    }

    @Override
    public void draw()
    {
        System.out.println( "       ^       " );
        System.out.println( "   (       )   " );
        System.out.println( "(              )" );
        System.out.println( "   (       )   " );
        System.out.println( "       ^       " );
    }
}
