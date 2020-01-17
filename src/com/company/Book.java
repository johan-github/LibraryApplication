package com.company;

public class Book {

    private String title;
    private String author;
    private String shortDescription;
    private boolean availability = false;

    //Constructor
    public Book (String title, String author, String shortDescription, boolean availability) {
        this.title = title;
        this.author = author;
        this.shortDescription = shortDescription;
        this.availability = availability;
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


    // toString
    @Override
    public String toString() {
        return "\n" + "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Description: " + shortDescription + "\n";
    }

}
