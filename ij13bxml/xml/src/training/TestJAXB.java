package training;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.List;

/**
 * Package Name: training
 * Author: chandrav
 */
public class TestJAXB
{
	private static Schema schema = null;

	private static final String TRAINING_SCHEMA = "/home/chandrav/IdeaProjects/ij13bxml/xml/src/training.xsd";

	private static Schema getTrainingSchema( String fileName )
	{
		if ( schema == null )
		{
			SchemaFactory sf = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
			try
			{
				schema = sf.newSchema( new File( fileName ) );
			}
			catch ( SAXException e )
			{
				e.printStackTrace();
			}
		}
		return schema;
	}

	private static void serialize( JAXBContext ctxt, Object obj, String outputFileName ) throws Exception
	{
		if ( ctxt != null && obj != null )
		{
			String outFileName = outputFileName == null || outputFileName.length() == 0 ? "/tmp/out.xml" : outputFileName;
			// create the marshaller to marshal the data from java objects to xml
			Marshaller m = ctxt.createMarshaller();
			m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

			// Get the schema and apply on the marshaller before marshalling the data
			Schema schema = TestJAXB.getTrainingSchema( TestJAXB.TRAINING_SCHEMA );
			m.setSchema( schema );
			// Now begin marshalling the data
			m.marshal( obj, new File( outFileName ) );
		}
	}

	private static Course createCourse( ObjectFactory of, String cName, int cCode, EnumCourseType cType, XMLGregorianCalendar cBeginDate )
	{
		Course c = of.createCourse();
		c.setName( cName );
		c.setCode( cCode );
		c.setCourseType( cType );
		c.setBeginDate( cBeginDate );

		return c;
	}

	private static XMLGregorianCalendar createCalendar(int year, int month, int day, int hour, int minute, int second )
	{
		XMLGregorianCalendar xgc = null;
		try
		{
			DatatypeFactory dtf = DatatypeFactory.newInstance();
			xgc = dtf.newXMLGregorianCalendar( year, month, day, hour, minute, second, 0, DatatypeConstants.FIELD_UNDEFINED );
		}
		catch ( DatatypeConfigurationException e )
		{
			e.printStackTrace();
		}
		return xgc;
	}

	private static Institute createData( ObjectFactory of )
	{
		// Create the institute
		Institute inst = of.createInstitute();
		inst.setName( "dots2drops" );

		// Create a courses object
		Courses courses = of.createCourses();

		// Create java course
		XMLGregorianCalendar beginDate = TestJAXB.createCalendar( 2014, 01, 15, 9, 00, 00 );
		Course c1 = TestJAXB.createCourse( of, "Java", 1350, EnumCourseType.Foundation, beginDate );
		Course c2 = TestJAXB.createCourse( of, "HTML5, CSS3", 1351, EnumCourseType.FastTrack, beginDate );
		XMLGregorianCalendar vBeginDate = TestJAXB.createCalendar( 2014, 02, 01, 16, 30, 00 );
		Course c3 = TestJAXB.createCourse( of, "Virtualization", 1352, EnumCourseType.FastTrack, vBeginDate );

		courses.getCourse().add( c1 );
		courses.getCourse().add( c2 );
		courses.getCourse().add( c3 );

		inst.setCourses( courses );
		return inst;
	}

	private static Institute deserialize( JAXBContext ctxt, String xmlFile ) throws Exception
	{
		if ( ctxt != null && xmlFile != null && xmlFile.length() > 0 )
		{
			// Create the unmarshaller
			Unmarshaller um = ctxt.createUnmarshaller();
			// Get the schema to be validated against
			Schema schema = TestJAXB.getTrainingSchema( TestJAXB.TRAINING_SCHEMA );
			um.setSchema( schema );
			Object obj = um.unmarshal( new File( xmlFile ) );
			if ( obj instanceof Institute )
			{
				return (Institute) obj;
			}
		}
		return null;
	}

	private static void printInsituteAfterUnmarshalling( Institute i )
	{
		System.out.println( "Institute details after unmarshalling" );
		System.out.println( "Institute Name : " + i.getName() );
		Courses cs = i.getCourses();
		if ( cs != null )
		{
			List<Course> courseList = cs.getCourse();
			if ( courseList != null && !courseList.isEmpty() )
			{
				for ( Course c : courseList )
				{
					System.out.println("-----------------------");
					System.out.println( "Course Name : " + c.getName() );
					System.out.println( "Course Begin Date : " + c.getBeginDate() );
					System.out.println( "Course Code : " + c.getCode() );
					System.out.println( "Course Type : " + c.getCourseType() );
				}
			}

		}
	}

	public static void main( String[] args )
	{
		try
		{
			ObjectFactory of = new ObjectFactory();
			Institute inst = TestJAXB.createData( of );
			JAXBContext ctxt = JAXBContext.newInstance( Institute.class );
			TestJAXB.serialize( ctxt, inst, "/tmp/out.xml" );
			System.out.println( "Unmarshalling the generated xml" );
			Institute i = TestJAXB.deserialize( ctxt, "/tmp/out.xml" );
			if ( i != null )
			{
				TestJAXB.printInsituteAfterUnmarshalling( i );
			}
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
}
