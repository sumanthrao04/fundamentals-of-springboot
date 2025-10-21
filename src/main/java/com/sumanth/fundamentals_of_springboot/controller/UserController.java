package com.sumanth.fundamentals_of_springboot.controller;

import com.sumanth.fundamentals_of_springboot.dto.request.UserCreateRequestDto;
import com.sumanth.fundamentals_of_springboot.dto.response.UserCreateResponseDto;
import com.sumanth.fundamentals_of_springboot.dto.response.UserResponseDto;
import com.sumanth.fundamentals_of_springboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "User  management Controller",
        description = " CRUD Operation REST Api for User management"
)
@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    //build create User REST API

    @Operation(summary = "Creates the User", description = "Creates the User and saved into database")
    @ApiResponse(responseCode = "201",description = "Message: User Got Created, Thanks for Choosing our Health Insurance")
    @PostMapping("/createUser")
    public ResponseEntity<UserCreateResponseDto> createUser( @Valid @RequestBody UserCreateRequestDto user){
        UserCreateResponseDto savedUser =  userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Get user by id")
    @ApiResponse(responseCode = "200", description = "User found")
    @GetMapping("{UserID}")
    public ResponseEntity<UserResponseDto> getUserByID(@PathVariable("UserID") Long id){
        UserResponseDto getuserById= userService.getUserByID(id);
        return new ResponseEntity<>(getuserById,HttpStatus.OK);
    }

    @Operation(summary = "List all the users")
    @ApiResponse(responseCode = "200", description = "Users found")
    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        List<UserResponseDto> getAllUser = userService.getAllUser();
        return new ResponseEntity<>(getAllUser,HttpStatus.OK);
    }

    @Operation(summary = "Update the user By ID")
    @ApiResponse(responseCode = "200", description = "User got updated")
    @PutMapping("{id}")
    public ResponseEntity<UserResponseDto> updateUser( @PathVariable("id") Long userId , @Valid @RequestBody UserCreateRequestDto user){
        UserResponseDto updatUser=  userService.updateUser(userId, user);
        return new ResponseEntity<>(updatUser,HttpStatus.OK);
    }

    @Operation(summary = "Delete the user by ID")
    @ApiResponse(responseCode = "200", description = "Users found")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById( @PathVariable("id") Long id){
        userService.deleteUSer(id);
        return new ResponseEntity<>("The User got deleted " ,HttpStatus.OK);
    }
}
