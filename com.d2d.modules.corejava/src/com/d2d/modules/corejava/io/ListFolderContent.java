package com.d2d.modules.corejava.io;

import java.io.File;

public class ListFolderContent
{

    public static void main( String[] args )
    {
        String folderName = "C:\\D2D\\java\\Sample\\ABC_0";
        File folder = new File( folderName );

        if ( folder.isDirectory() )
        {
            File[] children = folder.listFiles( new JavaFileFilter() );
            if ( children != null && children.length > 0 )
            {
                for ( File child : children )
                {
                    System.out.println( child.getAbsolutePath()
                            + " is a file : " + child.isFile() );
                }
            }
        }
    }

}
