package com.sumanth.fundamentals_of_springboot.service;

import com.sumanth.fundamentals_of_springboot.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserByID(Long id);
    List<User> getAllUser();
    User updateUser(User user);

    void deleteUSer(Long id);
}
