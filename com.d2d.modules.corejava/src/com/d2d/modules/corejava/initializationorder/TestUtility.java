package com.d2d.modules.corejava.initializationorder;

public class TestUtility
{
    private static Person p = new Person("TestUtilityPerson");
    
    private static Employee e = new Employee("TestUtilityEmployee");

    public static void main( String[] args )
    {
        System.out.println( "Inside main() of TestUtility" );
        // Person p = new Person( "ABC" );
        // dumpInformation( p );
        //
        // Employee e = new Employee( "123" );
        // dumpInformation( e );
        //
        // Person pp = new Employee( "ABC", "123" );
        // dumpInformation( pp );

    }

    public static void dumpInformation( Person p )
    {
        if ( p instanceof Employee )
        {
            ( (Employee) p ).printDetails();
        }
        else
        {
            p.printDetails();
        }
    }
}
