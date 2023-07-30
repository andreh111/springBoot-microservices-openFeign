package com.andreh.apirequest.services;

import com.andreh.apirequest.mappers.UserMapper;
import com.andreh.apirequest.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public User getUserById(Long id){
        return this.userMapper.getUserById(id);
    }

    public void createUser(User user) {
        userMapper.insertUser(user);
    }

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

}
