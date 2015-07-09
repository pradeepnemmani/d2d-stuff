package com.d2d.modules.corejava.collections;

import java.util.Comparator;

public class SortDescendingComparator implements Comparator<String>
{

    @Override
    public int compare( String o1, String o2 )
    {
        if ( o1 != null && o2 != null )
        {
            // If control comes here, it implies both
            // o1 and o2 are not null.
            // Use the compareTo method to compare o1 and o2
            return -o1.compareTo( o2 );
        }
        return 0;
    }

}
