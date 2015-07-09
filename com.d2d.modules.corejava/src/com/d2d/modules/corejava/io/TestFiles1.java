package com.d2d.modules.corejava.io;

import java.io.File;

public class TestFiles1
{

    public static void main( String[] args )
    {

        File folder = new File( "C:\\D2D\\java\\Sample\\sample1" );
        System.out.println( "Folder is readable : " + folder.canRead() );
        boolean created = folder.mkdirs();
        if ( created )
        {
            System.out.println( "Folder was created..." );
        }
        boolean isFolder = folder.isDirectory();
        System.out
                .println( "The java.io.File object that we created is a Folder - "
                        + isFolder );

        File javaFile = new File(
                "C:\\D2D\\java\\DisplayMultiplicationTable.java" );
        System.out.println( "Is the java file a folder : " + javaFile.isDirectory() );
        
        System.out.println( "Executable : " + javaFile.canExecute() );
        System.out.println( "Readable : " + javaFile.canRead() );
        System.out.println( "Writable : " + javaFile.canWrite() );

    }

}
