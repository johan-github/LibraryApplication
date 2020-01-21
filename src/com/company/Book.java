package com.company;

import java.io.Serializable;

public class Book implements Serializable {

    private String title;
    private String author;
    private String shortDescription;
    private boolean available = false;

    //Constructor
    public Book (String title, String author, String shortDescription, boolean available) {
        this.title = title;
        this.author = author;
        this.shortDescription = shortDescription;
        this.available = available;
    }

    // Make attributes usable through these getters.
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getShortDescription() {
        return shortDescription;
    }
    public boolean isAvailable() {
        return available = true;
    }
    public boolean NotAvailable(){
        return available = false;
    }

    // toString
    @Override
    public String toString() {
        return "\n" + "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Description: " + shortDescription + "\n";
    }

}
