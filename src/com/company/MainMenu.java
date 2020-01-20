package com.company;

import java.util.Scanner;

public class MainMenu {

// This menu will be visible for everyone.


public MainMenu(){

    Choices();

}

boolean programIsRunning = true;

    public void Choices() {


        while (programIsRunning) {

            System.out.println();
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
                    String inputFromUser = input.nextLine();

                    break;

                case "2":
                    System.out.println("Please enter your New username");
                    String newUserName = input.nextLine();

                    break;

                case "0":
                    System.out.println("Shutting down program, please come back soon! :-)");
                    System.exit(0);
                default:
            }

        }
    }
}
