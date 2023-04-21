package com.geekster.UserManagementSystem.repository;

import com.geekster.UserManagementSystem.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo {

    private List<User> userList;

    public UserRepo() {
        userList = new ArrayList<>();
        User user = new User("1","vivek","vivekPatel","Faridabad,Haryana","7701852442");
        userList.add(user);
    }

    public  List<User> getAllUserFromRepo(){
        return userList;
    }

    public boolean sendUsertoRepo(User user){

        userList.add(user);
        return true;
    }

    public boolean deleteFromDB(User user){
        userList.remove(user);
        return true;
    }

    public boolean updateUserInDB(List<User> filteredUserList){
        userList = filteredUserList;
        return true;
    }
}
