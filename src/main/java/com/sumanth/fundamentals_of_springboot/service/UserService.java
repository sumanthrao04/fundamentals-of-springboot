package com.sumanth.fundamentals_of_springboot.service;

import com.sumanth.fundamentals_of_springboot.dto.request.UserCreateRequestDto;
import com.sumanth.fundamentals_of_springboot.dto.response.UserCreateResponseDto;
import com.sumanth.fundamentals_of_springboot.dto.response.UserResponseDto;
import com.sumanth.fundamentals_of_springboot.entity.User;

import java.util.List;

public interface UserService {

    UserCreateResponseDto createUser(UserCreateRequestDto user);
    UserResponseDto getUserByID(Long id);
    List<UserResponseDto> getAllUser();
    UserResponseDto updateUser( Long id,UserCreateRequestDto user);

    void deleteUSer(Long id);
}
