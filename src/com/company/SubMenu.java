package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class SubMenu {

private BookManager bookManager;
private UserManager userManager;
private User userClass;

    public SubMenu(){
        this.bookManager = new BookManager();
        bookManager.loadBooks();
        this.userManager = new UserManager();

        Decisions();
    }

    public void Decisions(){

    boolean subMenuRunning = true;

        while (subMenuRunning){

            System.out.println("----------------------------------------------------------");
            System.out.println("Please select number below, proceed with <ENTER>\n");
            System.out.println("[1] See ALL books (titles) that the Readers Inn have." +
                    " (Here you can also see individual description of the books)");
            System.out.println("[2] Search by title or author");
            System.out.println("[3] See all books that are available to borrow." +
                    " (Chose this option if you also might want to loan a book)");
            System.out.println("[4] See all books I posses." +
                    " (Chose this if you also might want to return a book)");
            System.out.println("[5] ONLY FOR ADMIN --- See all users and number of borrowed books individually");
            System.out.println("[6] ONLY FOR ADMIN --- Search for a specific user.");
            System.out.println("[7] ONLY FOR ADMIN --- Remove a specific user.");
            System.out.println("[0] Save, log out and return to Main menu");

            Scanner input = new Scanner(System.in);
            String userInput = input.next();
            //String inputFromUser = input.next();

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
                    String c2 = input.next();
                    bookManager.searchTitleOrAuthor(c2);
                    break;

                case "3":
                    bookManager.showAvailableBooks();
                    System.out.println("\nIf you wish to borrow a book, please enter the number " +
                            "next to the title. That book will be added to your personal cart.\n" +
                            "If you wish to NOT borrow a book, return to previous menu by typing " +
                            "[0] + <ENTER>.");
                    bookManager.borrowBookByIndex();
                    break;

                case "4":
                    // Show books user have, also gives opportunity to return one book.
                    bookManager.showUserBorrowedBooks();
                    break;

                case "5":
                    // See all users, ADMIN only
                    if (UserManager.activeUser.getUserRestriction().equals("customer")) {
                        System.out.println("Sorry, you don't have authority to use this, \n" +
                                "please make another choice.\n Returning to menu...");
                    }
                    else {
                        System.out.println("Checking user authority... \nAdmin confirmed." +
                                "\nPrinting list of all users...");
                        userManager.showAllUsers();
                    }
                    break;

                case "6":
                    // Search for- and option to Remove user, ADMIN only
                    if (UserManager.activeUser.getUserRestriction().equals("customer")) {
                        System.out.println("Sorry, you don't have authority to use this, \n" +
                                "please make another choice.\n Returning to menu...");
                    }
                    else {
                        System.out.println("Checking user authority... \nAdmin confirmed." +
                                "\nType in the full name of the user that you're looking for:");
                        userManager.searchForUserByName();
                    }
                    break;

                case "7":
                    if (UserManager.activeUser.getUserRestriction().equals("customer")) {
                        System.out.println("Sorry, you don't have authority to use this, \n" +
                                "please make another choice.\n Returning to menu...");
                    }
                    else {
                        System.out.println("Checking user authority... \nAdmin confirmed.");
                        userManager.removeCustomerFromList();
                    }
                    break;

                case "0":
                    // Save, log out and return to Main menu
                    System.out.println("Logging off, please wait...");
                    bookManager.saveBooks();
                    //userManager.saveUsers();
                    subMenuRunning = false;
                    break;
                default:

            }
        }

    }

}
