package com.d2d.modules.corejava.threads.producerconsumer;

public class Phone implements IPhone
{
    private String modelNumber;

    private String serialNumber;

    private int manufacturingYear;

    @Override
    public String getModelNumber()
    {
        return modelNumber;
    }

    @Override
    public void setModelNumber( String modelNumber )
    {
        this.modelNumber = modelNumber;

    }

    @Override
    public String getSerialNumber()
    {
        return serialNumber;
    }

    @Override
    public void setSerialNumber( String serialNumber )
    {
        this.serialNumber = serialNumber;
    }

    @Override
    public int getManufacturingYear()
    {
        return manufacturingYear;
    }

    @Override
    public void setManufacturingYear( int manufacturingYear )
    {
        this.manufacturingYear = manufacturingYear;

    }

    @Override
    public String toString()
    {
        return getModelNumber() + " (" + getSerialNumber() + "), "
                + getManufacturingYear();
    }

}
