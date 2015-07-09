package com.d2d.modules.corejava.io;

import java.io.File;
import java.io.FilenameFilter;

public class JavaFileFilter implements FilenameFilter
{

    @Override
    public boolean accept( File dir, String name )
    {
        String absoluteChildName = dir.getAbsolutePath() + "\\" + name;

        File f = new File( absoluteChildName );
        if ( f.isDirectory() )
        {
            return false;
        }
        if ( name.endsWith( ".java" ) )
        {
            return true;
        }

        return false;
    }

}
