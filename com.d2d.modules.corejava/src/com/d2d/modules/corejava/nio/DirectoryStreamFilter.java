package com.d2d.modules.corejava.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirectoryStreamFilter implements DirectoryStream.Filter<Path>
{

    @Override
    public boolean accept( Path entry ) throws IOException
    {
        if ( Files.isDirectory( entry ) )
        {
            return true;
        }
        return false;
    }

}
