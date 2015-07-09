package com.d2d.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Package Name: com.d2d.spring.org
 * Author: chandrav
 */
public class Organization
{
	private String name;
	private Person ceo;
	private Person chairman;
	private String id;
	private List<Person> employees;

	public Organization( final Person ceo, final Person chairman )
	{
		System.out.println( "Inside Organization's parameterized constructor" );
		this.ceo = ceo;
		this.chairman = chairman;
	}

	public Organization()
	{
		System.out.println( "Inside Organization's default constructor" );
	}

	public String getName()
	{
		return name;
	}

	public void setName( final String name )
	{
		this.name = name;
	}

	public Person getCeo()
	{
		return ceo;
	}

	public void setCeo( final Person ceo )
	{
		this.ceo = ceo;
	}

	public List<Person> getEmployees()
	{
		return employees;
	}

	public void setEmployees( final List<Person> employees )
	{
		this.employees = employees;
	}

	public void addEmployee( Person p )
	{
		if ( employees == null )
		{
			employees = new ArrayList<>();
		}
		employees.add( p );
	}

	public Person getChairman()
	{
		return chairman;
	}

	public void setChairman( final Person chairman )
	{
		this.chairman = chairman;
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
		return getName() + ", CEO [" + getCeo() + "]";
	}
}
