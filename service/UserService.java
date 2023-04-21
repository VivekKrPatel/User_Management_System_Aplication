package com.geekster.UserManagementSystem.service;

import com.geekster.UserManagementSystem.models.User;
import com.geekster.UserManagementSystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> getAllUserFromService(){
        return userRepo.getAllUserFromRepo();
    }

    public String sendUsertoService(User user){
        boolean isUserInserted = userRepo.sendUsertoRepo(user);
        if(isUserInserted){
            return "Added user successfully...!!!";
        }
        return "Failed to Add user....!!!";
    }

    public User getUserFromService(String userId){
        List<User> userList = getAllUserFromService();
        for(User user:userList){
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        return new User();
    }

    public String deleteUserFromService(String userId){
        List<User> userList = getAllUserFromService();
        if(userId != null){
            for(User user:userList){
                if(user.getUserId().equals(userId)){
                    if(userRepo.deleteFromDB(user)){
                        return "userId: " + userId + " has been deleted Successfully..!!!";
                    }
                }
            }
            return "userId: " + userId + " does not exist..!!";
        }else{
            return "Kindly give the userId to delete it from database";
        }
    }

    public String updateUserFromService(String userId,String newAddress){

        List<User> userList = getAllUserFromService();
        List<User> filteredUserList = new ArrayList<>();
        if(userId == null && newAddress == null){
            for(User user:userList){
                if(user.getUserId().equals(userId)){
                    user.setAddress(newAddress);
                    filteredUserList.add(user);
                }else{
                    filteredUserList.add(user);
                }
            }
            boolean isUpdated = userRepo.updateUserInDB(filteredUserList);
            if(isUpdated) {
                return "userId: " + userId +" address updated SuccesFully";
            }else{
                return "Failed....!!!  userId: "+userId+" has not been updated due to database error...";
            }
        }
        return "userId or address can not be null";
    }
}
