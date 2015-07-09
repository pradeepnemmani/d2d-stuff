package com.d2d.modules.corejava.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TestHashMap
{

    public static void main( String[] args )
    {

        HashMap<Integer, String> myMap = new HashMap<>();
        System.out.println( "Populating the hashmap" );
        for ( int inx = 0; inx < 10; inx++ )
        {
            String value = "String - " + inx;
            myMap.put( inx, value );
        }
        System.out.println( "Printing the content of hashmap..." );
        Set<Integer> keys = myMap.keySet();
        for ( Integer key : keys )
        {
            // Get the value for this key from the hashmap
            String value = myMap.get( key );
            System.out.println( key + " = " + value );
        }

        // Simpler but complex to begin with
        // Retrieve the data from the hashmap as pairs (i.e. entries)

        System.out.println( "Simpler way of retrieving values from Map" );
        for ( Entry<Integer, String> entry : myMap.entrySet() )
        {
            System.out.println( entry.getKey() + " = " + entry.getValue() );
        }

        System.out
                .println( "Testing HashMap with key as string and value as string" );
        TreeMap<String, String> myMap2 = new TreeMap<>();

        myMap2.put( "USERPROFILE", "C:\\Users\\chandrav" );
        myMap2.put( "VBOX_INSTALL_PATH", "C:\\apps\\VirtualBox\\" );
        myMap2.put( "TEMP", "C:\\Users\\chandrav\\AppData\\Local\\Temp" );
        myMap2.put( "USERDOMAIN", "kesav" );
        myMap2.put( "TMP", "C:\\Users\\chandrav\\AppData\\Local\\Temp" );
        myMap2.put( "USERDOMAIN_ROAMINGPROFILE", "kesav" );
        myMap2.put( "CLASSPATH", "c:\\D2D\\java" );
        myMap2.put( "USERNAME", "chandrav" );
        myMap2.put( "windir", "C:\\windows" );
        myMap2.put( "CommonProgramFiles(x86)",
                "C:\\Program Files (x86)\\Common Files" );
        myMap2.put( "CommonProgramW6432", "C:\\Program Files\\Common Files" );
        myMap2.put( "COMPUTERNAME", "KESAV" );
        myMap2.put( "ALLUSERSPROFILE", "C:\\ProgramData" );
        myMap2.put( "APPDATA", "C:\\Users\\chandrav\\AppData\\Roaming" );
        myMap2.put( "CommonProgramFiles", "C:\\Program Files\\Common Files" );
        myMap2.put( "ComSpec", "C:\\windows\\system32\\cmd.exe" );

        System.out.println( "Environment variables inside my hashmap..." );
        for ( Entry<String, String> entry : myMap2.entrySet() )
        {
            System.out.println( entry.getKey() + " = " + entry.getValue() );
        }

        HashMap<String, List<String>> booksReadByPeople = new HashMap<>();

        // Books read by Sugandhi
        List<String> bookNames = new ArrayList<>();
        bookNames.add( "jQuery" );
        bookNames.add( "Head First Java" );
        bookNames.add( "Picnic To Hell" );
        // Add books read by Sugandhi
        booksReadByPeople.put( "Sugandhi", bookNames );

        // Books read by Krishna
        List<String> booksReadByKrishna = new ArrayList<>();
        booksReadByKrishna.add( "I too had a Love Story" );
        booksReadByKrishna.add( "Ramayana" );
        booksReadByKrishna.add( "Mahabharata" );
        booksReadByKrishna.add( "Ramayana" );
        // Add books read by Krishna
        booksReadByPeople.put( "Krishna", booksReadByKrishna );

        for ( Entry<String, List<String>> entry : booksReadByPeople.entrySet() )
        {
            String personName = entry.getKey();
            List<String> booksRead = entry.getValue();
            System.out.println( "Books read by - " + personName );
            System.out.println( "------------------------" );
            for ( String book : booksRead )
            {
                System.out.println( book );
            }
            System.out.println( "------------------------" );
        }

        booksReadByPeople.put( "Krishna", null );
        for ( Entry<String, List<String>> entry : booksReadByPeople.entrySet() )
        {
            String personName = entry.getKey();
            List<String> booksRead = entry.getValue();
            System.out.println( "Books read by - " + personName );
            System.out.println( "------------------------" );
            if ( booksRead != null )
            {
                for ( String book : booksRead )
                {
                    System.out.println( book );
                }
            } else
            {
                System.out.println( ">>>>NONE<<<<" );
            }
            System.out.println( "------------------------" );
        }

        HashMap<String, HashMap<String, List<String>>> foodByPeople = new HashMap<>();
        // Krishna
        // Main Course - Aloo Fry, Dal Curry
        // Dessert - Ice Cream
        // Sugandhi
        // Main Course - Bhendi Fry
        // Dessert - Choco Lava Cake

        // Krishna
        HashMap<String, List<String>> foodItemsByKrishna = new HashMap<>();
        // main course
        List<String> mainCourseItemsByKrishna = new ArrayList<>();
        mainCourseItemsByKrishna.add( "Aloo Fry" );
        mainCourseItemsByKrishna.add( "Dal Curry" );
        foodItemsByKrishna.put( "Main Course", mainCourseItemsByKrishna );
        // dessert menu
        List<String> dessertCourseItemsByKrishna = new ArrayList<>();
        dessertCourseItemsByKrishna.add( "Ice Cream" );
        foodItemsByKrishna.put( "Dessert", dessertCourseItemsByKrishna );

        foodByPeople.put( "Krishna", foodItemsByKrishna );

        // Print the various food items by respective individuals
        for ( Entry<String, HashMap<String, List<String>>> foodItemByPerson : foodByPeople
                .entrySet() )
        {
            String personName = foodItemByPerson.getKey();
            HashMap<String, List<String>> foodItems = foodItemByPerson
                    .getValue();
            System.out.println( "**** Food Items brought by - " + personName
                    + " ****" );
            for ( Entry<String, List<String>> courseItem : foodItems.entrySet() )
            {
                String courseName = courseItem.getKey();
                List<String> courseItemNames = courseItem.getValue();
                System.out.println( " >>> " + courseName + " <<<" );
                for ( String courseItemName : courseItemNames )
                {
                    System.out.println( courseItemName );
                }
            }
        }
    }

}
