package com.d2d.modules.corejava.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class CheckFileAttributes
{

    public static void main( String[] args ) throws Exception
    {

        if ( args.length != 1 )
        {
            System.out.println( "Specify a location" );
            return;
        }

        // Convert to a Path object for the specified input.
        Path path = Paths.get( args[0] );
        if ( Files.exists( path ) )
        {
            BasicFileAttributeView bfav = Files.getFileAttributeView( path,
                    BasicFileAttributeView.class );
            BasicFileAttributes bfa = bfav.readAttributes();
            System.out.println( "Last access time : " + bfa.lastAccessTime() );
            System.out.println( "Last modified time : "
                    + bfa.lastModifiedTime() );

            DosFileAttributeView dfav = Files.getFileAttributeView( path,
                    DosFileAttributeView.class );
            DosFileAttributes dfa = dfav.readAttributes();
            System.out.println( "Is hidden file " + dfa.isHidden() );
        }
        else
        {
            System.out.println( "Specified location does not exist." );
        }
    }

}
