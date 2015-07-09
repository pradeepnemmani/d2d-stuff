package com.d2d.modules.corejava.enums;

public class FoodItem
{
    private String name;
    private EnumSpicynessLevel spicynessLevel;

    public FoodItem()
    {
        // TODO Auto-generated constructor stub
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public EnumSpicynessLevel getSpicynessLevel()
    {
        return spicynessLevel;
    }

    public void setSpicynessLevel( EnumSpicynessLevel spicynessLevel )
    {
        this.spicynessLevel = spicynessLevel;
    }

    public static void main( String[] args )
    {
        FoodItem mixedVegCurry = new FoodItem();
        mixedVegCurry.setName( "Mixed Vegetable Curry" );
        mixedVegCurry.setSpicynessLevel( EnumSpicynessLevel.EXTRA_HOT );
    }
}
