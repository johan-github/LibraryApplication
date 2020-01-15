package com.company;

public class Book {

    private String title;
    private String author;
    private String shortDescription;

    //Constructor
    public Book (String title, String author, String shortDescription) {
        this.title = title;
        this.author = author;
        this.shortDescription = shortDescription;
    }

    // Let user see requested attribute by these getters.
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
