package com.company;

public class Program {


    public Program() {

        BookManager bookManager = new BookManager();
        bookManager.loadBooks();

        UserManager userManager = new UserManager();
        userManager.loadUsers();

        new MainMenu().Choices();

    }


}
