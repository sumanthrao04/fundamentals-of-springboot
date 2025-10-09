package com.sumanth.fundamentals_of_springboot.service.impl;

import com.sumanth.fundamentals_of_springboot.entity.User;
import com.sumanth.fundamentals_of_springboot.repository.UserRepository;
import com.sumanth.fundamentals_of_springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    //only one dependency and constructor no need to add auto wired after spring 4.3+
    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
      // modifying the user details as required
      String getUserFirstName=  user.getFirstName().toUpperCase();
      user.setFirstName(getUserFirstName);
      String getUserLastname = user.getLastName().toUpperCase();
      user.setLastName(getUserLastname);
      String getUserEmail = user.getEmail().replaceAll("gmail","endava");
      user.setEmail(getUserEmail);
        return userRepository.save(user);
    }

    @Override
    public User getUserByID(Long id) {

    Optional<User> optionalUser= userRepository.findById(id);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        Long userByID = user.getId();
        user.setId(userByID);
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail().replaceAll("gmail","endava"));

        return userRepository.save(user);
    }

    @Override
    public void deleteUSer(Long id) {
        userRepository.deleteById(id);
    }

}
