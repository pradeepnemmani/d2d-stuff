package com.d2d.modules.corejava.abstractclasses;

public abstract class AbstractShape
{
    private String name;

    public AbstractShape()
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public abstract double calculateArea();

    public abstract void rotate( double angleInDegrees );

    public abstract void draw();
}
