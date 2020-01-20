package com.company;

import java.util.Scanner;

public class SubMenu {

private BookManager bookManager;

    public SubMenu(){
        this.bookManager = new BookManager();
        bookManager.loadBooks();

        Decisions();
    }


    public void Decisions(){
    boolean subMenuRunning = true;
        while (subMenuRunning){

            System.out.println("----------------------------------------------------------");
            System.out.println("Please select number below, proceed with <ENTER>");
            System.out.println();
            System.out.println("[1] See ALL books (titles) that the Readers Inn have (here you can also see individual description of all books");
            System.out.println("[2] Search by title or author");
            System.out.println("[3] See all books that are available (chose this if you also want to loan a book)");
            System.out.println("[4] See all books I posses (chose this if you also want to return a book)");
            System.out.println("[0] Log out and go back to Main menu");

            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            String inputFromUser = input.nextLine();

            switch (userInput){
                case "1":
                    System.out.println("Printing all books...");
                    bookManager.showBookTitle();
                    System.out.println("Do you wish to see a description of one of the books?");
                    System.out.println("If so, enter the ID of the book you wish to see.");

                    bookManager.searchTitleOrAuthor(inputFromUser);
                    break;

                case "2":
                    bookManager.searchTitleOrAuthor(inputFromUser);
                    break;

                case "3":
                    bookManager.showAvailableBooks();
                    // Here the user can chose if she/he want to loan a book.
                    break;

                case "4":


                case "0":
                    subMenuRunning = false;
                    break;

            }
        }

    }

}
