package com.d2d.modules.corejava.generics;

public class Fruit extends Produce implements IFruit
{
    private String color;

    @Override
    public String getColor()
    {
        return color;
    }

    @Override
    public void setColor( String color )
    {
        this.color = color;
    }

}
