package com.example.web4.service;

import com.example.web4.entity.UserEntity;
import com.example.web4.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public void addUser(UserEntity user) {
        userRepo.save(user);
    }

    public UserEntity findByLogin(String login) {
        return userRepo.findByLogin(login);
    }
}
