package com.d2d.modules.corejava.io;

import java.io.File;

public class PrintFolderChildren
{
    private static void printFolderContent( int level, File folder )
    {
        // Display tabs based on the level
        for ( int inx = 0; inx < level; inx++ )
        {
            System.out.print( "  " );
        }
        // Print the folder name adjacent to the tabs
        System.out.println( folder.getAbsolutePath() );
        // Get the files under the specified folder object
        if ( folder.isDirectory() )
        {
            File[] files = folder.listFiles();
            if ( files != null )
            {
                for ( File child : files )
                {
                    PrintFolderChildren.printFolderContent( level + 1, child );
                }
            }
        }
    }

    public static void main( String[] args )
    {
        if ( args.length != 1 )
        {
            System.out
                    .println( "Invalid number of inputs specified. Please specify only one input which should be the folder name for which the children have to be retrieved." );
            return;
        }
        // If the control comes to this point, it implies that the user has
        // specified only one input.
        String location = args[0];
        File rootLocation = new File( location );
        if ( !rootLocation.isDirectory() )
        {
            System.out
                    .println( "Invalid input specified. Please specify a folder and not a file" );
            return;
        }
        // If the control comes to this point, it implies that the input
        // specified is a valid input i.e. folder
        PrintFolderChildren.printFolderContent( 0, rootLocation );
    }
}
