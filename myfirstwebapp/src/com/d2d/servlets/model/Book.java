package com.d2d.servlets.model;

public class Book
{
    private String title;
    private String isbnCode;
    private String author;
    private String publishedYear;
    private double price;
    private long creationTime;

    public String getTitle()
    {
        return title;
    }

    public void setTitle( String title )
    {
        this.title = title;
    }

    public String getIsbnCode()
    {
        return isbnCode;
    }

    public void setIsbnCode( String isbnCode )
    {
        this.isbnCode = isbnCode;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor( String author )
    {
        this.author = author;
    }

    public String getPublishedYear()
    {
        return publishedYear;
    }

    public void setPublishedYear( String publishedYear )
    {
        this.publishedYear = publishedYear;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice( double price )
    {
        this.price = price;
    }

    public long getCreationTime()
    {
        return creationTime;
    }

    public void setCreationTime( long creationTime )
    {
        this.creationTime = creationTime;
    }

}
