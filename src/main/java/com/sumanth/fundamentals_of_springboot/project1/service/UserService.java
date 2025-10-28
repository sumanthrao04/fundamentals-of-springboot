package com.sumanth.fundamentals_of_springboot.project1.service;

import com.sumanth.fundamentals_of_springboot.project1.dto.request.UserCreateRequestDto;
import com.sumanth.fundamentals_of_springboot.project1.dto.response.UserCreateResponseDto;
import com.sumanth.fundamentals_of_springboot.project1.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {

    UserCreateResponseDto createUser(UserCreateRequestDto user);
    UserResponseDto getUserByID(Long id);
    List<UserResponseDto> getAllUser();
    UserResponseDto updateUser( Long id,UserCreateRequestDto user);

    void deleteUSer(Long id);
}
