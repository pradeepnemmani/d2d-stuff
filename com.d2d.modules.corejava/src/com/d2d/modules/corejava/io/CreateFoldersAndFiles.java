package com.d2d.modules.corejava.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateFoldersAndFiles
{
    private static Random random = new Random();

    private static void createFiles( File parent, int limit )
            throws IOException
    {
        if ( parent != null && parent.isDirectory() && limit > 0 )
        {
            for ( int inx = 0; inx < limit; inx++ )
            {
                String extension = null;
                if ( inx % 5 == 0 )
                {
                    extension = ".log";
                }
                else if ( inx % 2 == 0 )
                {
                    extension = ".txt";
                }
                else if ( inx % 3 == 0 )
                {
                    extension = ".java";
                }
                else
                {
                    extension = ".tmp";
                }

                String fileName = random.nextInt( 10000000 ) + extension;
                String absolutePath = parent.getAbsolutePath() + File.separator
                        + fileName;
                File newFile = new File( absolutePath );
                newFile.createNewFile();
            }
        }
    }

    private static List<File> createFolders( File parent, String pattern,
            int limit )
    {
        List<File> folders = new ArrayList<>();
        if ( parent != null && parent.isDirectory() && pattern != null
                && limit > 0 )
        {
            for ( int inx = 0; inx < limit; inx++ )
            {
                String folderName = pattern + "_" + inx;
                File newFolder = new File( parent.getAbsolutePath()
                        + File.separator + folderName );
                boolean created = newFolder.mkdir();
                if ( created )
                {
                    folders.add( newFolder );
                }
            }
        }
        return folders;
    }

    public static void main( String[] args )
    {
        String tempLocation = System.getenv( "TMP" );
        File rootFolder = new File( tempLocation + File.separator + "sample" );
        if ( !rootFolder.exists() )
        {
            rootFolder.mkdirs();
        }
        List<File> folders = createFolders( rootFolder, "ABC", 10 );
        if ( folders != null && !folders.isEmpty() )
        {
            for ( File folder : folders )
            {
                try
                {
                    createFiles( folder, random.nextInt( 50 ) );
                }
                catch ( IOException e )
                {
                    e.printStackTrace();
                }
            }
        }
    }

}
