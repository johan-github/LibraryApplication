package com.company;

public class Book {

    private String title;
    private String author;
    private String shortDescription;

    public Book (String title, String author, String shortDescription) {
        this.title = title;
        this.author = author;
        this.shortDescription = shortDescription;
    }

    @Override
    public String toString() {
        return "\n" + "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Description: " + shortDescription + "\n";
    }
}
