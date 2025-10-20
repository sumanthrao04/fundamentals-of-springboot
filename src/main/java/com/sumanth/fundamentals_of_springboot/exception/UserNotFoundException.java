package com.sumanth.fundamentals_of_springboot.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("User : " +id+" : Not Found");
    }
}
