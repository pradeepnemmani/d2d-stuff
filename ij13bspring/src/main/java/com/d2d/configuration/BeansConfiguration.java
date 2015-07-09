package com.d2d.configuration;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Package Name: com.d2d.configuration
 * Author: chandrav
 */
@Configuration
@ComponentScan( basePackages = {"com.d2d"} )
public class BeansConfiguration
{
	@Bean
	public GraphDatabaseService graphDatabaseService()
	{
		System.out.println("Establishing connection to the database...");
		GraphDatabaseService gds = new GraphDatabaseFactory().newEmbeddedDatabase( "/tmp/orgdb" );
		System.out.println("Established connection to the database!!!");
		return gds;
	}
}
