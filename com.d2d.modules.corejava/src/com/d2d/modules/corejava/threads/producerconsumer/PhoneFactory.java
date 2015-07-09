package com.d2d.modules.corejava.threads.producerconsumer;

import java.util.Random;

public final class PhoneFactory
{
    private static Random random = new Random();

    private PhoneFactory()
    {

    }

    /**
     * @param modelNumber
     * @param serialNumber
     * @param mfgYear
     * @return
     */
    public static Phone createPhone( String modelNumber, String serialNumber,
            int mfgYear )
    {
        Phone p = new Phone();
        p.setModelNumber( modelNumber );
        p.setSerialNumber( serialNumber );
        p.setManufacturingYear( mfgYear );

        return p;
    }

    public static Phone createPhone()
    {
        Phone p = new Phone();
        p.setModelNumber( "Samsung Galaxy S4" );
        p.setSerialNumber( "SGS4 - " + PhoneFactory.random.nextInt( 1000000 ) );
        p.setManufacturingYear( 2014 );

        return p;
    }
}
