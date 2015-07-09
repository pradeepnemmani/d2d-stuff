package com.d2d.spring;

import com.d2d.model.Organization;
import com.d2d.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp
{
	public static void main( String[] args )
	{
		ApplicationContext context = new ClassPathXmlApplicationContext( "d2d-beans.xml" );
		Organization org = context.getBean( "orgBean", Organization.class );
		System.out.println( "Organization Name : " + org.getName() );
		System.out.println( "---CEO Details---" );
		Person ceo = org.getCeo();
		if( ceo != null )
		{
			System.out.println( "First Name : " + ceo.getFirstName() );
			System.out.println( "Last Name : " + ceo.getLastName() );
			System.out.println( "Age : " + ceo.getAge() );
		}
		System.out.println("---Chairman Details---");
		Person chairman = org.getChairman();
		if( chairman != null )
		{
			System.out.println( "First Name : " + chairman.getFirstName() );
			System.out.println( "Last Name : " + chairman.getLastName() );
			System.out.println( "Age : " + chairman.getAge() );
		}
//		System.out.println( "---Employee Details---" );
//		List<Person> employees = org.getEmployees();
//		if ( employees != null && !employees.isEmpty() )
//		{
//			for ( Person employee : employees )
//			{
//				System.out.println( "First Name : " + employee.getFirstName() );
//				System.out.println( "Last Name : " + employee.getLastName() );
//				System.out.println( "Age : " + employee.getAge() );
//			}
//		}

//		Person person = context.getBean( "personBean", Person.class );
//		System.out.println( person.getFirstName() );
//		System.out.println( person.getLastName() );
//		System.out.println( person.getAge() );
//		Person person1 = context.getBean( "personBean", Person.class );
//		System.out.println( person1.getFirstName() );
//		System.out.println( person1.getLastName() );
//		System.out.println( person1.getAge() );
	}
}
