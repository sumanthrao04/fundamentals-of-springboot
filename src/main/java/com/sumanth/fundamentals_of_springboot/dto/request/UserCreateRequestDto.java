package com.sumanth.fundamentals_of_springboot.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String insuranceProvider;
    private String aadhaarNumber;
    private String mobileNumber;


}
