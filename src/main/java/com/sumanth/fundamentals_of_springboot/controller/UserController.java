package com.sumanth.fundamentals_of_springboot.controller;

import com.sumanth.fundamentals_of_springboot.dto.request.UserCreateRequestDto;
import com.sumanth.fundamentals_of_springboot.dto.response.UserCreateResponseDto;
import com.sumanth.fundamentals_of_springboot.dto.response.UserResponseDto;
import com.sumanth.fundamentals_of_springboot.entity.User;
import com.sumanth.fundamentals_of_springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    //build create User REST API

    @PostMapping("/createUser")
    public ResponseEntity<UserCreateResponseDto> createUser(@RequestBody UserCreateRequestDto user){
        UserCreateResponseDto savedUser =  userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{UserID}")
    public ResponseEntity<UserResponseDto> getUserByID(@PathVariable("UserID") Long id){
        UserResponseDto getuserById= userService.getUserByID(id);
        return new ResponseEntity<>(getuserById,HttpStatus.OK);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        List<UserResponseDto> getAllUser = userService.getAllUser();
        return new ResponseEntity<>(getAllUser,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserResponseDto> updateUser( @PathVariable("id") Long userId , @RequestBody UserCreateRequestDto user){
        UserResponseDto updatUser=  userService.updateUser(userId, user);
        return new ResponseEntity<>(updatUser,HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById( @PathVariable("id") Long id){
        userService.deleteUSer(id);
        return new ResponseEntity<>("The User got deleted " ,HttpStatus.OK);
    }
}
