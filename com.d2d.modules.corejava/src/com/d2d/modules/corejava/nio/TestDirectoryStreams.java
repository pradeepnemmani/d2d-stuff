package com.d2d.modules.corejava.nio;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestDirectoryStreams
{

    public static void main( String[] args ) throws Exception
    {
        Path directory = Paths
                .get( "C:\\Users\\chandrav\\AppData\\Local\\Temp" );
        DirectoryStream<Path> children = Files.newDirectoryStream( directory,
                new DirectoryStreamFilter() );
        for ( Path child : children )
        {
            System.out.println( child.toString() );
        }
    }

}
