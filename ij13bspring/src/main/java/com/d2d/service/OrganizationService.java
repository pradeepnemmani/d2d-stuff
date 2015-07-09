package com.d2d.service;

import com.d2d.model.Organization;
import com.d2d.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Package Name: com.d2d.service
 * Author: chandrav
 */
@Component("organizationService")
public class OrganizationService
{
	private List<Organization> organizations = new ArrayList<>();

	@Autowired
	private PersonService personService;

	/**
	 *
	 * @return
	 */
	public List<Organization> getAllOrganizations()
	{
		return organizations;
	}

	/**
	 *
	 * @param name
	 * @return
	 */
	public Organization create( String name )
	{
		Organization org = new Organization();
		org.setName( name );
		org.setId( UUID.randomUUID().toString() );

		// Add the created organization to the in-memory collection
		organizations.add( org );
		return org;
	}

	/**
	 * @param id
	 * @return
	 */
	public Organization find( String id )
	{
		Organization org = null;

		if ( StringUtils.hasLength( id ) && !organizations.isEmpty() )
		{
			for ( Organization organization : organizations )
			{
				if ( organization.getId().equals( id ) )
				{
					org = organization;
					break;
				}
			}
		}
		return org;
	}

	/**
	 * @param orgId
	 * @param ceoId
	 */
	public void setCeo( String orgId, String ceoId )
	{
		// Find the organization by orgId
		Organization org = find( orgId );
		if ( org != null )
		{
			// Find person by id
			// If we found a person, we set that person as the
			// ceo on the organization
			Person ceo = personService.find( ceoId );
			if ( ceo != null )
			{
				org.setCeo( ceo );
				org.addEmployee( ceo );
			}
		}
	}

	/**
	 * @param orgId
	 * @param eFirstName
	 * @param eLastName
	 * @param eAge
	 */
	public void addEmployee( String orgId, String eFirstName, String eLastName, int eAge )
	{
		if ( StringUtils.hasLength( orgId ) )
		{
			Organization org = find( orgId );
			if ( org != null )
			{
				Person emp = personService.create( eFirstName, eLastName, eAge );
				org.addEmployee( emp );
			}
		}

	}
}
