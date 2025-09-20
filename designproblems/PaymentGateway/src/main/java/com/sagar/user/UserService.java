package com.sagar.user;

import java.util.*;

public class UserService {
    static List<User> usersList = new ArrayList<>();

    public UserDO addUser(UserDO userDO) {
        // some validations and create User obj
        User userObj = new User();
        userObj.setUserName(userDO.getName());
        userObj.setEmail(userDO.getMail());
        userObj.setUserID(new Random().nextInt(90) + 10); // random between 10-99
        usersList.add(userObj);
        return convertUserToUserDO(userObj);
    }

    public UserDO getUser(int userID) {
        for (User user : usersList) {
            if (user.getUserID() == userID) {
                return convertUserToUserDO(user);
            }
        }
        return null;
    }

    private UserDO convertUserToUserDO(User userObj) {
        UserDO userDO = new UserDO();
        userDO.setName(userObj.getUserName());
        userDO.setMail(userObj.getEmail());
        userDO.setUserID(userObj.getUserID());
        return userDO;
    }
}
