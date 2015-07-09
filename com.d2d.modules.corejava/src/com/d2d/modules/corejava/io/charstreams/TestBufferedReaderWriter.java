package com.d2d.modules.corejava.io.charstreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

public class TestBufferedReaderWriter
{

    public static void main( String[] args )
    {
        if ( args.length != 2 )
        {
            System.out
                    .println( "Please specify an input file and output file." );
            return;
        }

        File inputFile = new File( args[0] );
        if ( !inputFile.isFile() )
        {
            System.out
                    .println( "Specified input is not a file. Please specify a file." );
            return;
        }
        File outputFile = new File( args[1] );

        try ( BufferedReader br = new BufferedReader(
                new FileReader( inputFile ) );
                BufferedWriter bw = new BufferedWriter( new FileWriter(
                        outputFile ) ) )
        {
            String line = null;

            while ( ( line = br.readLine() ) != null )
            {
                bw.write( line );
                bw.write( "\n" );
            }
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
        }


        try (BufferedWriter bw1 = new BufferedWriter( new OutputStreamWriter( new FileOutputStream( "" ) ) ))
        {
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
