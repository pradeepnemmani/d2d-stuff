package com.d2d.modules.corejava.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ItemsInventory<K, V>
{
    private Set<K> keys;

    private Collection<V> values;

    public ItemsInventory()
    {
        keys = new LinkedHashSet<>();
        values = new ArrayList<>();
    }

    public void put( K key, V value )
    {
        if ( keys != null && values != null )
        {
            keys.add( key );
            values.add( value );
        }
    }

    public Set<K> keySet()
    {
        return keys;
    }

    public Collection<V> values()
    {
        return values;
    }

    public V getValue( K keyToRetrieve )
    {
        V value = null;

        Iterator<K> keyIt = keys.iterator();
        Iterator<V> valueIt = values.iterator();
        
        while( keyIt.hasNext() && valueIt.hasNext() )
        {
            K key = keyIt.next();
            if( key.equals( keyToRetrieve ) )
            {
                value = valueIt.next();
                break;
            }
            valueIt.next();
        }
        
        /*
        int counter = 0;
        for ( K key : keys )
        {
            if ( key.equals( keyToRetrieve ) )
            {
                break;
            }
            counter++;
        }

        int indexToRetrieve = 0;
        Iterator<V> it = values.iterator();
        while ( it.hasNext() )
        {
            if ( indexToRetrieve == counter )
            {
                value = it.next();
                break;
            }
            it.next();
            indexToRetrieve++;
        }
        */

        return value;
    }

    public static void main( String[] args )
    {
        ItemsInventory<Integer, String> inv = new ItemsInventory<>();
        inv.put( 1, "A" );
        inv.put( 2, "B" );
        inv.put( 3, "C" );
        
        // print the inventory items.
        System.out.println("Inventory items...");
        Set<Integer> keys = inv.keySet();
        for( Integer key : keys )
        {
            System.out.println( key + " = " + inv.getValue( key ) );
        }
    }
}
