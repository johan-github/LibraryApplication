package com.company;

import java.util.ArrayList;

public class UserManager {

private User activeUser;
private ArrayList<User> listOfUsers;

    public UserManager() {
        // load users from file
    }

    public void setActiveUser(User user){
        activeUser = user;
    }
    public User getActiveUser(){
        return activeUser;
    }

}
