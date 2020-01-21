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
            System.out.println("Please select number below, proceed with <ENTER>\n");
            System.out.println("[1] See ALL books (titles) that the Readers Inn have" +
                    " (here you can also see individual description of all books");
            System.out.println("[2] Search by title or author");
            System.out.println("[3] See all books that are available to borrow (chose this if you also want to loan a book)");
            System.out.println("[4] See all books I posses (chose this if you also want to return a book)");
            System.out.println("[0] Log out and go back to Main menu");

            Scanner input = new Scanner(System.in);
            String userInput = input.next(); // Removed "Line"
            String inputFromUser = input.nextLine();

            switch (userInput){
                case "1":
                    System.out.println("All books within Readers Inn:");
                    bookManager.showTitleWithIndex();
                    System.out.println("\nDo you wish to see a description of one of the books?\n" +
                    "If so, enter the ID of the book you wish to see (number next to the titles).\n" +
                    "If not, press 0 to return to previous menu.");
                    bookManager.bookChoiceDescription();

                    break;

                case "2":
                    System.out.println("What author or title are you looking for?");
                    inputFromUser = input.next();
                    bookManager.searchTitleOrAuthor(inputFromUser);
                    break;

                case "3":
                    bookManager.showAvailableBooks();
                    // Here the user can chose if she/he want to loan a book.
                    break;

                case "4":
                    // Show books user have, also gives opportunity to return one book.

                    break;

                case "0":
                    System.out.println("Logging off, please wait...");
                    subMenuRunning = false;
                    break;

            }
        }

    }

}
