package com.d2d.modules.corejava.initializationorder;

public class Employee extends Person
{
    private String id;
    
    private static Person pp = new Person("Dummy");

    public Employee()
    {
        System.out.println( "Inside Employee() constructor" );
        System.out.println( "Inside Employee() constructor, id : " + id );
    }

    public Employee( String id )
    {
        this.id = id;
        System.out.println( "Inside Employee(String id) constructor" );
        System.out.println( "Inside Employee(String id) constructor, id : " + id );
    }
    
    public Employee( String firstName, String id )
    {
        super( firstName );
        this.id = id;
        System.out.println( "Inside Employee(String firstName, String id) constructor" );
        System.out.println( "Inside Employee(String firstName, String id) constructor, id : " + id + ", first name : " + firstName );
    }

    public String getId()
    {
        return id;
    }

    public void setId( String id )
    {
        this.id = id;
    }

    @Override
    public void printDetails()
    {
        System.out.println( "Person's Name : " + getFirstName() + ", Id : "
                + getId() );
    }

}
