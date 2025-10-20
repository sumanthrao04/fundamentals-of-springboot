package com.sumanth.fundamentals_of_springboot.service.impl;

import com.sumanth.fundamentals_of_springboot.dto.mapper.UserMapper;
import com.sumanth.fundamentals_of_springboot.dto.request.UserCreateRequestDto;
import com.sumanth.fundamentals_of_springboot.dto.response.UserCreateResponseDto;
import com.sumanth.fundamentals_of_springboot.dto.response.UserResponseDto;
import com.sumanth.fundamentals_of_springboot.entity.User;
import com.sumanth.fundamentals_of_springboot.exception.UserNotFoundException;
import com.sumanth.fundamentals_of_springboot.repository.UserRepository;
import com.sumanth.fundamentals_of_springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    //only one dependency and constructor no need to add auto wired after spring 4.3+
    private UserRepository userRepository;


    @Override
    public UserCreateResponseDto createUser(UserCreateRequestDto user) {
      // modifying the user details as required
        User saved =  userRepository.save(UserMapper.mapToEntity(user));
        return  UserMapper.toCreateUSerResponse(saved);
    }

    @Override
    public UserResponseDto getUserByID(Long id) {
    User  optionalUser =  userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
        return UserMapper.fullUserData(optionalUser);
    }

    @Override
    public List<UserResponseDto> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::fullUserData).toList() ;
    }

    @Override
    public UserResponseDto updateUser(Long id,UserCreateRequestDto user) {
        User updateduser = userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
        updateduser.setFirstName(user.getFirstName());
        updateduser.setLastName(user.getLastName());
        updateduser.setMobileNumber(user.getMobileNumber());
        updateduser.setAadhaarNumber(user.getAadhaarNumber());
        updateduser.setEmail(user.getEmail());
        User saved = userRepository.save(updateduser);
        return UserMapper.fullUserData(saved);
    }

    @Override
    public void deleteUSer(Long id) {
        if(!userRepository.existsById(id)) throw new UserNotFoundException(id);
        userRepository.deleteById(id);
    }

}
