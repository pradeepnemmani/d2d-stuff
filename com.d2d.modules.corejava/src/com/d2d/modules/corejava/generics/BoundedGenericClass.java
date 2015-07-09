package com.d2d.modules.corejava.generics;

public class BoundedGenericClass<T extends IProduce>
{
    private T data;

    public T getData()
    {
        return data;
    }

    public void setData( T data )
    {
        this.data = data;
    }

    public static void main( String[] args )
    {
        IFruit apple = new Fruit();
        apple.setName( "Apple" );
        apple.setColor( "Red" );

        IVegetable tomato = new Vegetable();
        tomato.setName( "Tomato" );

        // BoundedGenericClass<Fruit> f = <Fruit>new BoundedGenericClass<>();
        // f.setData( new Fruit() );

    }
}
