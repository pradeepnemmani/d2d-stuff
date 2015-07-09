package com.d2d.modules.corejava.initializationorder;

public class Person
{
    private String firstName;

    public Person()
    {
        System.out.println( "Inside Person() constructor" );
        System.out.println( "Inside Person() constructor, firstName : " + firstName );
    }

    public Person( String firstName )
    {
        this.firstName = firstName;
        System.out.println( "Inside Person(String firstName) constructor, firstName : " + firstName );
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public void printDetails()
    {
        System.out.println( "Person's Name : " + firstName );
    }
}
