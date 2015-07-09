package com.d2d.modules.corejava.threads.producerconsumer;

import java.util.LinkedList;

public class SamsungInventory
{

    private LinkedList<Phone> inventory;

    private int inventoryCapacity = 10;

    public SamsungInventory()
    {
        inventory = new LinkedList<>();
    }

    public SamsungInventory( int defaultInventorySize )
    {
        this();
        inventoryCapacity = defaultInventorySize;
    }

    public synchronized void produce()
    {
        if ( inventory.size() == inventoryCapacity )
        {
            System.out
                    .println( "Inventory is full.... Waiting for someone to consume..." );
            try
            {
                wait();
            }
            catch ( InterruptedException e )
            {
                System.out.println( "Interrupted..." + e.getMessage() );
            }
        }
        // Then only produce.
        Phone p = PhoneFactory.createPhone();
        inventory.add( p );
        System.out.println( "Produced phone : " + p );
        notifyAll();
    }

    public synchronized Phone consume()
    {
        Phone p = null;
        // Object monitor = new Object();
        if ( inventory.size() <= 0 )
        {
            try
            {
                System.out
                        .println( "Waiting for some phone to appear in the inventory..." );
                wait();
            }
            catch ( InterruptedException e )
            {
                System.out.println( "Interrupted..." + e.getMessage() );
            }
        }
        p = inventory.poll();
        System.out.println( "Consume the phone : " + p );
        notifyAll();

        return p;
    }
}
