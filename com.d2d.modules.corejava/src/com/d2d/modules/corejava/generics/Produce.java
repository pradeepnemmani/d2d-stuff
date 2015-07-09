package com.d2d.modules.corejava.generics;

public class Produce implements IProduce
{
    private String name;

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName( String name )
    {
        this.name = name;
    }

}
