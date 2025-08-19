package com.tracker.services;

import com.tracker.entities.User;
import com.tracker.pojos.UserRequestPojo;
import com.tracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(Integer ID){
        return userRepository.getUserById(ID);
    }

    public User getUserByName(String name){
        return userRepository.getUserByName(name);
    }


    public String createUser(UserRequestPojo userRequestPojo){

        User user = new User();
        user.setUsername(userRequestPojo.getUsername());
        if(userRequestPojo.getPassword()==null || userRequestPojo.getPassword().equals("")){
            return "password is empty";
        } else if (userRequestPojo.getPassword().contains(".")) {
            return "password is not valid";
        }
        user.setPassword(userRequestPojo.getPassword());
        user.setEmail(userRequestPojo.getEmail());
        if(userRequestPojo.getEmail() !=null && !userRequestPojo.getEmail().contains("@")){
            return "email is not valid";
        }
        user.setCreatedAt(new Date());
        userRepository.createUser(user);

        return "success";

    }
}
