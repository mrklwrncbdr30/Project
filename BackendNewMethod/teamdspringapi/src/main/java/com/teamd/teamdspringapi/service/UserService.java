package com.teamd.teamdspringapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.teamd.teamdspringapi.entity.Users;
import com.teamd.teamdspringapi.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository UserRepository;

    public List<Users> getAllUsers() {
        return UserRepository.findAll();
    }

    public Users getUsersById(Long UserID) {
        return UserRepository.findById(UserID).orElse(null);
    }

    public Users saveUsers(Users users) {
        return UserRepository.save(users);
    }

    public void deleteUsers(Long UserID) {
        UserRepository.deleteById(UserID);
    }
}
