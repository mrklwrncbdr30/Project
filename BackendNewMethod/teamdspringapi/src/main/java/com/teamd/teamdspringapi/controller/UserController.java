package com.teamd.teamdspringapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.teamd.teamdspringapi.entity.Users;
import com.teamd.teamdspringapi.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:5173")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{UserID}")
    public Users getUsersById(@PathVariable Long UserID) {
        return userService.getUsersById(UserID);
    }

    @PostMapping
    public Users saveUsers(@RequestBody Users users) {
        return userService.saveUsers(users);
    }

    @DeleteMapping
    public void deleteUsers(@PathVariable Long UserID) {
        userService.deleteUsers(UserID);
    }
}