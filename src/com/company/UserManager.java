package com.company;

import java.nio.file.*;
import java.util.ArrayList;

public class UserManager {

    public static User activeUser;
    private ArrayList<User> listOfAllUsers;

    public UserManager() {

    }


    public void loopUsers(){
        for (User user : listOfAllUsers){
        }
    }


    public void createNewAdmin(){
        listOfAllUsers.add(new User("admin", "admin"));
    }


    public void createNewCustomer(String newUserName){
        listOfAllUsers.add(new User(newUserName, "Customer"));
        saveUsers();
        loopUsers();
        System.out.println(listOfAllUsers);
    }


    public void removeCustomerFromList(String inputFromUser){
        for (User user : listOfAllUsers){
            if (user.getUserName().toLowerCase().equals(inputFromUser.toLowerCase())){
                listOfAllUsers.remove(user);
                System.out.println("Successfully removed user: " + user.getUserName() + " from the system.");
                break;
            }
            if (!user.getUserName().toLowerCase().equals(inputFromUser.toLowerCase())){
                System.out.println("Did not find user with that name, please enter a " +
                        "valid username.\n" + "Returning to menu...");
                break;
            }
        }

    }


    /**
     * Check if username equals a name in the list of users
     *
     * @param inputFromUser input that user uses.
     */
    public User findUser(String inputFromUser) {
        //System.out.println(listOfAllUsers); // Shows only objects, not strings.
        for (User user : listOfAllUsers) {
            if (inputFromUser.equals(user.getUserName())) {
                return user;
            } else {
                return null;
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
