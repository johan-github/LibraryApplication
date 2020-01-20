package com.company;

import java.util.ArrayList;

public class UserManager {

    public static User activeUser;
    private ArrayList<User> listOfUsers;

    public UserManager() {
        // load users from file
    }

    /**
     * Check if username equals a name in the list of users
     *
     * @param inputFromUser input that user uses.
     */
    public User findUser(String inputFromUser) {
        for (User user : listOfUsers) {
            if (inputFromUser.equals(user.getUserName())) {
                return user;
            }
        }

        return null;
    }
    /*
    public void findUser(String inputFromUser){
        for (User user : listOfUsers)
        if (inputFromUser.toLowerCase().equals(user.toString().toLowerCase())){
            return user;
        }
        */

    public void setActiveUser(User user) {
        activeUser = user;
    }
}
