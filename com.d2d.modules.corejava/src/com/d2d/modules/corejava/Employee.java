package com.d2d.modules.corejava;

public class Employee
{

    private long id;

    private String name;

    private String contactNo;

    private String address;

    public Employee()
    {
        id = -1L;
        name = "Unknown";
        address = "Unknown";
        contactNo = "Unknown";
    }

    public Employee( long id, String name, String contactNo, String address )
    {
        super();
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
    }

    public Employee( long id, String name )
    {
        super();
        this.id = id;
        this.name = name;
    }

    public Employee( long id, String name, String contactNo )
    {
        super();
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
    }

    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getContactNo()
    {
        return contactNo;
    }

    public void setContactNo( String contactNo )
    {
        this.contactNo = contactNo;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress( String address )
    {
        this.address = address;
    }

    public static void main( String[] args )
    {
        Employee chandra = new Employee( 123, "Chandra", "9490946095",
                "Dots2Drops, Madhapur, Hyderabad" );
        System.out.println( "Id : " + chandra.getId() );
        System.out.println( "Name : " + chandra.getName() );
        System.out.println( "Address : " + chandra.getAddress() );
        System.out.println( "Contact Number :  " + chandra.getContactNo() );

        Employee unknownEmployee = new Employee();
        System.out.println( "Unknown Employee's contact number : "
                + unknownEmployee.getContactNo() );
        System.out.println( "Unknown Employee's id : "
                + unknownEmployee.getId() );
        System.out.println( "Unknown Employee's name : "
                + unknownEmployee.getName() );
    }

}
