package com.company;

import java.util.Scanner;

public class MainMenu {

    private SubMenu subMenu;
    private UserManager userManager;
    Scanner inputFromUser = new Scanner(System.in);

    public MainMenu(){
        userManager = new UserManager();
        userManager.loadUsers();

        Choices();
    }

    private void nextMenu (){
        subMenu = new SubMenu();
    }

    private void checkIfUserExist(){
        String userInput = inputFromUser.nextLine();
        User user = userManager.findUser(userInput);
        if (user != null){
            userManager.setActiveUser(user);
            System.out.println("Welcome User: " + user.getUserName() + "!");
            nextMenu();
        } else {
            System.out.println("User not recognized, please enter a valid username or register at start menu.");
        }
    }

    public void Choices() {

        while (true) {

            System.out.println("----------------------------------------------------------");
            System.out.println("Welcome to the library " + "'Readers Inn'!");
            System.out.println("Please select 1-3 below, proceed with <ENTER>");
            System.out.println();
            System.out.println("[1] Log in");
            System.out.println("[2] Register as new user");
            System.out.println("[0] Exit");


            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();

            switch (userInput) {
                case "1":
                    System.out.println("Please enter your username");
                    checkIfUserExist();

                    break;

                case "2":
                    System.out.println("Please enter your New username");
                    String newUserName = input.nextLine();
                    userManager.createNewCustomer(newUserName);
                    System.out.println("Welcome " + newUserName + "!");
                    break;

                case "0":
                    System.out.println("Shutting down program, please come back soon! :-)");
                    System.exit(0);
                default:
            }

        }
    }
}
