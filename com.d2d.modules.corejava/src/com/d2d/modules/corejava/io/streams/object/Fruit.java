package com.d2d.modules.corejava.io.streams.object;

import java.io.Serializable;

public class Fruit implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 2L;

    private String name;

    private EnumTaste taste;

    private EnumColor color;

    private double weight;

    private boolean seedless;

    public Fruit()
    {
        super();
    }

    public Fruit( String name, EnumTaste taste, EnumColor color )
    {
        super();
        this.name = name;
        this.taste = taste;
        this.color = color;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public EnumTaste getTaste()
    {
        return taste;
    }

    public void setTaste( EnumTaste taste )
    {
        this.taste = taste;
    }

    public EnumColor getColor()
    {
        return color;
    }

    public void setColor( EnumColor color )
    {
        this.color = color;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight( double weight )
    {
        this.weight = weight;
    }

    public boolean isSeedless()
    {
        return seedless;
    }

    public void setSeedless( boolean seedless )
    {
        this.seedless = seedless;
    }

}
