package com.d2d.modules.corejava.abstractclasses;

public class TestShapes
{

    public static void main( String[] args )
    {
        Circle circle = new Circle( 12.0 );
        circle.setName( "Circle" );
        System.out.println( "Radius of the circle : " + circle.getRadius() );
        System.out.println( "Area of the circle : " + circle.calculateArea() );
        circle.draw();

        Rectangle rect = new Rectangle( 10, 10 );
        rect.setName( "Rectangle" );
        System.out.println( "Shape Name : " + rect.getName() );
        System.out.println( "Area of the rectangle : " + rect.calculateArea() );
        rect.draw();
    }
}
