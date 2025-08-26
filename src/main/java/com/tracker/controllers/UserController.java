package com.tracker.controllers;

import com.tracker.entities.User;
import com.tracker.pojos.UserRequestPojo;
import com.tracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//it should return json

//Controller(it will communicate with frontend) <--- Service(it will contain business logic) ---> Repository -> it should communicate with database
@RequestMapping("users/")
public class UserController {

    @Autowired
    UserService userService;

    //uri
    //local-host:8080/users/get-user-by-id/1
    //get method, get, post, put,delete

    //endpoint
    @GetMapping("get-user-by-id/{id}")
    public User getUser(@PathVariable("id") Integer id)
    {
        System.out.println("id = " + id);
        return userService.getUserById(id);
    }

    @GetMapping("get-user-by-name/{name}")
    public User getUser(@PathVariable("name") String name)
    {
        return userService.getUserByName(name);
    }

    //We mayu encounter with maintainance issues and readability issues
    // we sagregate logic based on the category
    @PostMapping("create-user")
    public String createUser(@RequestBody UserRequestPojo userRequestPojo)
    {

        System.out.println("userRequestPojo.toString() = " + userRequestPojo.toString());
        return userService.createUser(userRequestPojo);
    }

}
