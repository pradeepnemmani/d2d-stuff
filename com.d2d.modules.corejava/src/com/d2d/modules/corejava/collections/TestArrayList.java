package com.d2d.modules.corejava.collections;

import java.util.ArrayList;

import com.d2d.modules.corejava.initializationorder.Person;

public class TestArrayList
{

    public static void main( String[] args )
    {
        ArrayList al = new ArrayList();
        al.add( "Some String" );
        al.add( "Another String" );
        al.add( 1, "Some Other String" );
        // AutoBoxing -> int is converted to Integer before adding
        al.add( 555 );
        // AutoBoxing -> boolean is converted to Boolean before adding
        al.add( false );
        // AutoBoxing -> char is converted to Character before adding
        al.add( 'C' );
        al.add( new Person( "Chandra" ) );

        for ( Object element : al )
        {
            // System.out.println( "Class Name of the element : " +
            // element.getClass().getName() );
            if ( element instanceof Integer )
            {
                Integer i = (Integer) element;
                System.out.println( "Integer value : " + i.intValue() );
            } else if ( element instanceof Boolean )
            {
                Boolean b = (Boolean) element;
                System.out.println( "Boolean value : " + b.booleanValue() );
            } else if ( element instanceof Character )
            {
                Character c = (Character) element;
                System.out.println( "Character value : " + c.charValue() );
            } else if ( element instanceof String )
            {
                String str = (String) element;
                System.out.println( "String value : " + str );
            } else if ( element instanceof Person )
            {
                Person p = (Person) element;
                System.out.println( "Name of the Person : " + p.getFirstName() );
            }
        }
    }

}
