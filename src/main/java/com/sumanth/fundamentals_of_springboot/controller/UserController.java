package com.sumanth.fundamentals_of_springboot.controller;

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
    public ResponseEntity<User> createUser( @RequestBody User user){
        User savedUser =  userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{UserID}")
    public ResponseEntity<User> getUserByID(@PathVariable("UserID") Long id){

        User getuserById= userService.getUserByID(id);
        return new ResponseEntity<>(getuserById,HttpStatus.OK);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> getAllUser = userService.getAllUser();
        return new ResponseEntity<>(getAllUser,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser( @PathVariable("id") Long userId , @RequestBody User user){
        user.setId(userId);
       User updatUser=  userService.updateUser(user);
        return new ResponseEntity<>(updatUser,HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById( @PathVariable("id") Long id){
        userService.deleteUSer(id);
        return new ResponseEntity<>("The User got deleted " ,HttpStatus.OK);
    }
}
