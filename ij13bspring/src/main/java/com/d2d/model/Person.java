package com.d2d.model;

/**
 * Package Name: com.d2d.spring.org
 * Author: chandrav
 */
public class Person
{
	private String firstName;
	private String lastName;
	private int age;
	private String id;

	public Person( final String age, final String firstName, final String lastName )
	{
		System.out.println( "In Person constructor with age as String" );
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person( final int age, final String firstName, final String lastName )
	{
		System.out.println( "In Person constructor with age as int" );
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Person()
	{
		System.out.println( "Inside Person's default constructor" );
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName( final String firstName )
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName( final String lastName )
	{
		this.lastName = lastName;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge( final int age )
	{
		this.age = age;
	}

	public String getId()
	{
		return id;
	}

	public void setId( final String id )
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		return getFirstName() + ", " + getLastName();
	}
}
