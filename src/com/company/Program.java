package com.company;

public class Program {


    public Program() {

        BookManager bookManager = new BookManager();
        bookManager.loadBooks();
        new MainMenu().Choices();

    }


}
