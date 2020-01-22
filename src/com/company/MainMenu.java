package com.company;

import java.util.Scanner;

public class MainMenu {

    private UserManager userManager;
    Scanner inputFromUser = new Scanner(System.in);

    public MainMenu(){
        userManager = new UserManager();
        userManager.loadUsers();

        Choices();
    }

    public static void nextMenu (){
        new SubMenu();
    }

    private void checkIfUserExist(){
        userManager.loadUsers();
        String userInput = inputFromUser.next();
        User user = userManager.findUser(userInput);
        if (user != null){
            userManager.setActiveUser(user);
            System.out.println("Welcome " + user.getUserName() + "!");
            nextMenu();
        } else {
            System.out.println("User not recognized, please enter a valid username" +
                    " or register as a new user at start menu.\nReturning to main menu...");
        }
    }


    public void Choices() {
        System.out.println("\nWelcome to the Readers Inn!");
        while (true) {

            System.out.println("----------------------------------------------------------");

            System.out.println("Please select 1-3 below, proceed with <ENTER>");
            System.out.println();
            System.out.println("[1] Log in");
            System.out.println("[2] Register as new user");
            System.out.println("[0] Save and Quit");


            Scanner input = new Scanner(System.in);
            String userInput = input.next();

            switch (userInput) {
                case "1":
                    System.out.println("Please enter your username");
                    checkIfUserExist();
                    break;

                case "2":
                    System.out.println("Please enter your New username, NO spaces");
                    String newUserName = input.next();
                    userManager.createNewCustomer(newUserName);
                    System.out.println("Welcome " + newUserName + "!");
                    System.out.println("Please use your new username to log in.");
                    Choices();
                    break;

                case "0":
                    System.out.println("Shutting down program, please come back soon! :-)");
                    System.exit(0);
                default:
            }

        }
    }
}
