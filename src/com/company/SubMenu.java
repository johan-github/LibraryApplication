package com.company;

import java.util.Scanner;

public class SubMenu {

private BookManager bookManager;
private UserManager userManager;

    public SubMenu(UserManager userManager){
        this.userManager = userManager;
        this.bookManager = new BookManager();
        Decisions();
    }


    public void Decisions(){
    boolean subMenuRunning = true;
        while (subMenuRunning){

            System.out.println("----------------------------------------------------------");
            System.out.println("Please select number below, proceed with <ENTER>");
            System.out.println();
            System.out.println("[1] See ALL books (titles) within the Readers Inn");
            System.out.println("[2] Search for a specific book by title");
            System.out.println("[3] Search for a specific book by author");
            System.out.println("[4] Search by title or author");
            System.out.println("[5] See all available books (chose this for opportunity to loan a book)");
            System.out.println("[6] See all books I borrow (chose this if you want to return a book)");
            System.out.println("[0] Log out and go back to Main menu");

            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();

            switch (userInput){
                case "1":
                    System.out.println("Printing all books...");
                    bookManager.showBookTitle();
                    break;
                case "0":
                    subMenuRunning = false;
                    break;
            }


        } // end while

    }

}
