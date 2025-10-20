package com.sumanth.fundamentals_of_springboot.dto.mapper;

import com.sumanth.fundamentals_of_springboot.dto.request.UserCreateRequestDto;
import com.sumanth.fundamentals_of_springboot.dto.response.UserCreateResponseDto;
import com.sumanth.fundamentals_of_springboot.dto.response.UserResponseDto;
import com.sumanth.fundamentals_of_springboot.entity.User;

public class UserMapper {

    public  static User mapToEntity (UserCreateRequestDto req){
        User  saveUser = new User();
        saveUser.setFirstName(req.getFirstName());
        saveUser.setLastName(req.getLastName());
        saveUser.setEmail(req.getEmail());
        saveUser.setAadhaarNumber(req.getAadhaarNumber());
        saveUser.setInsuranceProvider(req.getInsuranceProvider());
        saveUser.setMobileNumber(req.getMobileNumber());
        return saveUser;
    }

    public static UserCreateResponseDto toCreateUSerResponse(User savedUser){

        UserCreateResponseDto savedUserInDb = new UserCreateResponseDto();
        savedUserInDb.setId(savedUser.getId());
        savedUserInDb.setAadhaarNumber(savedUser.getAadhaarNumber());
        savedUserInDb.setStatus("User Got Created, Thanks for Choosing our Health Insurance");

        return savedUserInDb;

    }

    public static UserResponseDto fullUserData(User saveduser){
        UserResponseDto allSavedUser = new UserResponseDto();
        allSavedUser.setId(saveduser.getId());
        allSavedUser.setFirstName(saveduser.getFirstName());
        allSavedUser.setLastName(saveduser.getLastName());
        allSavedUser.setEmail(saveduser.getEmail());
        allSavedUser.setAadhaarNumber(saveduser.getAadhaarNumber());
        allSavedUser.setMobileNumber(saveduser.getMobileNumber());
        return allSavedUser;

    }

}
