package com.d2d.service;

import com.d2d.model.Person;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Package Name: com.d2d.service
 * Author: chandrav
 */
@Component( "personService" )
public class PersonService
{
	private List<Person> persons = new ArrayList<>();

	@Autowired
	private GraphDatabaseService graphDatabaseService;

	/**
	 * @return
	 */
	public List<Person> getAllPersons()
	{
		return persons;
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @return
	 */
	public Person create( String firstName, String lastName, int age )
	{
		Person p = null;
		try ( Transaction tx = graphDatabaseService.beginTx() )
		{
			Label personLabel = DynamicLabel.label( "Person" );
			Node personNode = graphDatabaseService.createNode( personLabel );
			personNode.setProperty( "firstName", firstName );
			personNode.setProperty( "lastName", lastName );
			personNode.setProperty( "age", age );
			tx.success();

			p = new Person();
			p.setId( String.valueOf( personNode.getId() ) );
			p.setFirstName( firstName );
			p.setLastName( lastName );
			p.setAge( age );
			// As we are storing the data in-memory and not the database,
			// i would like to store this new person object in to the
			// in-memory collection
			persons.add( p );
		}

		return p;
	}

	/**
	 * @param id
	 * @return
	 */
	public Person find( String id )
	{
		Person person = null;

		if ( StringUtils.hasLength( id ) && !persons.isEmpty() )
		{
			for ( Person p : persons )
			{
				if ( p.getId().equals( id ) )
				{
					person = p;
					break;
				}
			}
		}

		return person;
	}
}
