package com.d2d.test;

import com.d2d.service.PersonService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Package Name: com.d2d.test
 * Author: chandrav
 */
public class TestServices
{
	public static void main( String[] args )
	{
		// ApplicationContext context = new ClassPathXmlApplicationContext( "d2d-beans.xml" );
		try( ConfigurableApplicationContext context = new AnnotationConfigApplicationContext( "com.d2d.configuration" ))
		{
			PersonService ps = context.getBean( "personService", PersonService.class );
			ps.create( "Chandra", "Veerapaneni", 31 );

			/*
			OrganizationService os = context.getBean( "organizationService", OrganizationService.class );
			System.out.println( os );

			Organization o = os.create( "dots2drops" );
			System.out.println( o );

			PersonService ps = context.getBean( "personService", PersonService.class );
			Person ceo = ps.create( "Kesav", "Kasireddy", 30 );
			System.out.println( "CEO - " + ceo );

			o.setCeo( ceo );

			// Create the employees
			Person emp1 = ps.create( "Chandra", "Veerapaneni", 31 );
			o.addEmployee( emp1 );

			Person emp2 = ps.create( "Venkat", "Baddigam", 26 );
			o.addEmployee( emp2 );

			// Find all persons in the database
			System.out.println( "ALL PERSONS IN THE DATABASE" );
			List<Person> allPersons = ps.getAllPersons();
			if ( allPersons != null && !allPersons.isEmpty() )
			{
				for ( Person p : allPersons )
				{
					System.out.println( p );
				}
			}

			// Find all organizations and print the ceo and employees of the organization
			List<Organization> allOrgs = os.getAllOrganizations();
			if ( allOrgs != null && !allOrgs.isEmpty() )
			{
				for ( Organization or : allOrgs )
				{
					System.out.println( or );
					System.out.println( "-- Organization employees -- " );
					List<Person> emps = or.getEmployees();
					if ( emps != null && !emps.isEmpty() )
					{
						for ( Person emp : emps )
						{
							System.out.println( emp );
						}
					}
				}
			}
			*/
		}
	}
}
