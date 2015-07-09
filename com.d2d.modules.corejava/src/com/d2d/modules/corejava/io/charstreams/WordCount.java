package com.d2d.modules.corejava.io.charstreams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class WordCount
{

    public static void main( String[] args )
    {

        // 1. Program should accept one and only one argument which is the file
        // to be read
        // 2. If the number of specified arguments is not 1, display message and
        // return
        // 3. If the specified input argument is not a file, display message and
        // return
        // 4. Use the bufferedreader to read the file line by line
        // 5. For every line that is read, tokenize the line using space as the
        // delimiter.
        // 6. Maintain a HashMap which holds the word as the key, and the value
        // as the count
        // 7. For every token, check if it is already present in the map.
        // 8. If present, increment the existing value in the map
        // 9. If not present, add a new key-value pair in the map for the token
        // encountered
        // 10. Finally, release the resource
        // 11. Print the statistics

        if ( args.length != 1 )
        {
            System.out
                    .println( "Invalid number of arguments specified. Please specify the input file as an argument." );
            return;
        }

        // Check if it is a file or not.
        File inputFile = new File( args[0] );
        if ( !inputFile.isFile() )
        {
            System.out
                    .println( "Specified argument is not a file. Please ensure that you provide a file name as an input argument." );
            return;
        }

        try ( BufferedReader br = new BufferedReader(
                new FileReader( inputFile ) ) )
        {
            String line = null;
            Map<String, Integer> wordCountMap = new HashMap<>();
            while ( ( line = br.readLine() ) != null )
            {
                String[] tokens = line.split( " " );
                for ( String token : tokens )
                {
                    if ( wordCountMap.containsKey( token ) )
                    {
                        // present
                        int currentCount = wordCountMap.get( token );
                        currentCount++;
                        wordCountMap.put( token, currentCount );
                    }
                    else
                    {
                        // not present
                        wordCountMap.put( token, 1 );
                    }
                }
            }
            WordCount.printStatistics( wordCountMap );
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
        }
    }

    private static void printStatistics(
            Map<String, Integer> wordCountStatistics )
    {
        if ( wordCountStatistics != null && !wordCountStatistics.isEmpty() )
        {
            for ( Map.Entry<String, Integer> entry : wordCountStatistics
                    .entrySet() )
            {
                StringBuffer sb = new StringBuffer();
                sb.append( entry.getKey() );
                sb.append( " has occurred " );
                sb.append( entry.getValue() );
                sb.append( " times." );
                System.out.println( sb.toString() );
            }
        }
        else
        {
            System.out.println( "Map is empty..." );
        }
    }

}
