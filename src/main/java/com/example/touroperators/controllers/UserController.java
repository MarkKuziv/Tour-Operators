package com.example.touroperators.controllers;

import com.example.touroperators.Services.UserService;
import com.example.touroperators.entities.Company;
import com.example.touroperators.entities.Tour;
import com.example.touroperators.entities.UserEntities;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public List<UserEntities> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<UserEntities> getUsersById(@PathVariable Long id) throws Exception {
        return userService.getUserById(id);
    }

    @PostMapping(value = "/users/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUser(@RequestBody UserEntities user){
        return userService.addUser(user);
    }

    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        return userService.deletedUserById(id);
    }

    @PutMapping(value = "/users/update")
    public void UsersUpdate(@RequestBody UserEntities user){
        userService.updateUser(user);
    }
}
