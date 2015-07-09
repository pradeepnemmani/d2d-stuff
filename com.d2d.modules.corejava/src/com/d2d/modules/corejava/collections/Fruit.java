package com.d2d.modules.corejava.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class Fruit implements Iterable<String>, Comparable<Fruit>
{
    private String name;
    private String color;
    private String taste;
    private double weight;
    private boolean seedless;
    private ArrayList<String> characteristics;

    public Fruit()
    {
        super();
        characteristics = new ArrayList<>();
        characteristics.add( "name" );
        characteristics.add( "color" );
        characteristics.add( "taste" );
        characteristics.add( "weight" );
        characteristics.add( "seedless" );
    }

    public Fruit( String name )
    {
        this();
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor( String color )
    {
        this.color = color;
    }

    public String getTaste()
    {
        return taste;
    }

    public void setTaste( String taste )
    {
        this.taste = taste;
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

    @Override
    public Iterator<String> iterator()
    {
        return characteristics.iterator();
    }

    @Override
    public int compareTo( Fruit o )
    {
        int result = getName().compareTo( o.getName() );
        if ( result == 0 )
        {
            result = getWeight() > o.getWeight() ? -1 : 1;
        }
        return result;
    }

//    @Override
//    public boolean equals( Object obj )
//    {
//        // 1. Is the current object the same as the passed object
//        // 2. Is the current object's class the same as the passed object's class
//        // 3. Are the contents the same as the passed object's content
//        
//        if( this == obj )
//        {
//            return true;
//        }
//        if( getClass().getName().equals( obj.getClass().getName() ))
//        {
//            if( obj instanceof Fruit )
//            {
//                Fruit f = (Fruit) obj;
//                return getName().equals( f.getName() );
//            }
//        }
//        return false;
//    }
}
