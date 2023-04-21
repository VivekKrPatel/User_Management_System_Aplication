package com.geekster.UserManagementSystem.controller;

import com.geekster.UserManagementSystem.models.User;
import com.geekster.UserManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value ="/users",method = RequestMethod.GET)
    public List<User> getAllUserFromController(){
        return userService.getAllUserFromService();
    }

    @RequestMapping(value ="/user",method = RequestMethod.POST)
    public String sendUsertoController(@RequestBody User user){
        return userService.sendUsertoService(user);
    }

    @RequestMapping(value ="/bySpecificUserId/{userId}",method = RequestMethod.GET)
    public User getUserById(@PathVariable String userId){
        return userService.getUserFromService(userId);
    }

    @RequestMapping(value = "/bySpecificUserId/{userId}",method = RequestMethod.DELETE)
    public String deleteUserByUserId(@PathVariable String userId){
        return userService.deleteUserFromService(userId);
    }

    @RequestMapping(value = "/bySpecificUserId/{userId}/{address}",method = RequestMethod.PUT)
    public String updateByUserId(@PathVariable String userId,@PathVariable String NewAddress){
        return userService.updateUserFromService(userId,NewAddress);
    }
}
