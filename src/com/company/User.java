package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private String userName;
    private String userRestriction;
    private ArrayList<Book> borrowedBooks;

    public User(String userName, String userRestriction) {
        this.userName = userName;
        this.userRestriction = userRestriction;
        borrowedBooks = new ArrayList<>();
    }

    // Getters
    public String getUserName() {
        return userName;
    }
    public String getUserRestriction() {
        return userRestriction;
    }
    /**
     * Also SHOWS borrowed books.
     */
    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void addBookToUser(Book book){
        borrowedBooks.add(book);
    }


    public void removeBookFromUser(Book book){
        borrowedBooks.remove(book);
    }

}
