package com.company;

import java.nio.file.*;
import java.util.ArrayList;

public class UserManager {

    public static User activeUser;
    private ArrayList<User> listOfAllUsers;

    public UserManager() {

    }


    public void createNewAdmin(){
        listOfAllUsers.add(new User("admin", "admin"));
    }


    public void createNewCustomer(String newUserName){
        listOfAllUsers.add(new User(newUserName, "Customer"));
    }


    /**
     * Check if username equals a name in the list of users
     *
     * @param inputFromUser input that user uses.
     */
    public User findUser(String inputFromUser) {
        System.out.println(listOfAllUsers);
        for (User user : listOfAllUsers) {
            if (inputFromUser.equals(user.getUserName())) {
                return user;
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
