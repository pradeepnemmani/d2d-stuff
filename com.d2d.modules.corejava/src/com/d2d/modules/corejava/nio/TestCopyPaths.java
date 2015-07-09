package com.d2d.modules.corejava.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TestCopyPaths
{

    public static void main( String[] args ) throws Exception
    {
        if ( args.length != 1 )
        {
            System.out.println( "Input file needs to be specified." );
            return;
        }

        Path inputFilePath = Paths.get( args[0] );
        // We only support copying files. Verify if the retrieved path is truly
        // a file.
        if ( !Files.isRegularFile( inputFilePath ) )
        {
            System.out
                    .println( "Copying is allowed only on files. Please specify a file and not a directory." );
            return;
        }

        Path outputFilePath = Paths.get( inputFilePath.getParent().toString(),
                "copied-file.txt" );
        outputFilePath = Files.copy( inputFilePath, outputFilePath,
                StandardCopyOption.REPLACE_EXISTING );

        Path targetPath = Paths.get( outputFilePath.getParent().getParent()
                .toString(),
                outputFilePath.getName( outputFilePath.getNameCount() - 1 )
                        .toString() );
        Files.move( outputFilePath, targetPath,
                StandardCopyOption.REPLACE_EXISTING );
    }

}
