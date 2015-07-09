package com.d2d.modules.corejava.io.streams.object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Box implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<Fruit> fruits;

    public Box()
    {
        fruits = new ArrayList<>();
    }

    public List<Fruit> getFruits()
    {
        return fruits;
    }

    public void setFruits( List<Fruit> allFruits )
    {
        this.fruits = allFruits;
    }

    public void addFruit( Fruit someFruit )
    {
        if ( someFruit != null )
        {
            if ( fruits == null )
            {
                fruits = new ArrayList<>();
            }
            fruits.add( someFruit );
        }
    }

}
