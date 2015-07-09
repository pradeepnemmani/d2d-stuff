package com.d2d.modules.corejava.nio;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestPaths
{

    public static void main( String[] args )
    {
        if ( args.length != 1 )
        {
            System.out.println( "Please specify the base location." );
            return;
        }

        String baseLocation = args[0];

        Path path = Paths.get( baseLocation, "chandra", "28-Jan-2014", "logs",
                "abc.txt", ".", "..", "..", "logs", "abc.txt" );
        System.out.println( "Created Java Path Object : " + path.toString() );
        Path normalizedPath = path.normalize();
        System.out.println( "Normalized Path : " + normalizedPath.toString() );
        System.out
                .println( "Is absolute path : " + normalizedPath.isAbsolute() );
        System.out.println( "Root : " + normalizedPath.getRoot().toString() );
        // Get all the names in the path
        for ( int inx = 0; inx < normalizedPath.getNameCount(); inx++ )
        {
            // This is normally not an absolute path
            Path p = normalizedPath.getName( inx );
            System.out.println( p );
            System.out.println( "Is the path name an absolute path : "
                    + p.isAbsolute() );
        }

        FileSystem fs = FileSystems.getDefault();
        System.out.println( "My FileSystem Name : " + fs.getClass().getName() );
        // Get all the file system root directories
        Iterable<Path> rootDirectories = fs.getRootDirectories();
        for ( Path rootPath : rootDirectories )
        {
            System.out.println( rootPath );
        }
    }

}
