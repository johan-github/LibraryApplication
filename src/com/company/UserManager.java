package com.company;

import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {

    public static User activeUser;
    private ArrayList<User> listOfAllUsers;

    public UserManager() {

    }


    public void createNewAdmin(){
        listOfAllUsers.add(new User("admin", "admin"));
        saveUsers();
    }


    public void createNewCustomer(String newUserName){
        listOfAllUsers.add(new User(newUserName, "customer"));
        saveUsers();
        System.out.println("Sucessfully added: " + newUserName + " to the program");
    }

    public void showAllUsersAndNumberOfBooks(){
        loadUsers();
        for (User user : listOfAllUsers){
            System.out.println("User: " + user.getUserName()
            + "\n. Number of books in possession: " + (user.getBorrowedBooks().toString()) + "\n");
        }
    }


    public void searchForUserByName (){
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        //loadUsers();
        for (User user : listOfAllUsers){
            if (user.getUserName().equals(userInput)){
                System.out.println("User found: " + user.getUserName() +
                        ". Books user possess: " + user.getBorrowedBooks());
                System.out.println("\nReturning to previous menu...");
            }
        }
    }


    public void removeCustomerFromList(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the user you wish to remove from the program.\n" +
                "Please keep in mind that if you remove a user, all of it's content will be" +
                " deleted as well and there are no chance of undo this.");
        String input = scanner.next();
        for (User user : listOfAllUsers){
            if (user.getUserName().equals(input)){
                listOfAllUsers.remove(user);
                saveUsers();
                System.out.println("Successfully removed user: " + user.getUserName() + "from program.");
                System.out.println("Returning to previous menu...");
                break;
            }
        }
    }


    /**
     * Check if username equals a name in the list of users
     * When finished: Removed "else", it made loop end at first index
     * @param inputFromUser input that user uses.
     */
    public User findUser(String inputFromUser) {
        for (int i = 0; i < listOfAllUsers.size(); i++) {
            if (listOfAllUsers.get(i).getUserName().equals(inputFromUser)) {
                return listOfAllUsers.get(i);
            }
        }
        return null;
    }

    public void setActiveUser(User user) {
        activeUser = user;
    }


    public void saveUsers(){
        FileUtils.saveObject("users.ser", listOfAllUsers, StandardOpenOption.CREATE);
    }


    public void loadUsers(){
        Path path = Paths.get("users.ser");
        if (Files.exists(path)) {
            listOfAllUsers = (ArrayList<User>)FileUtils.loadObject("users.ser");
        }
        else {
            listOfAllUsers = new ArrayList<>();
            createNewAdmin();
            saveUsers();
        }
    }

}
