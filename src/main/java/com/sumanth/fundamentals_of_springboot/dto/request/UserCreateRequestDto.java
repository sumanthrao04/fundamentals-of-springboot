package com.sumanth.fundamentals_of_springboot.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequestDto {

    //user first name not be null or empty
    @NotEmpty(message = "user first name not be null or empty")
    private String firstName;

    //user lastName  not be null or empty
    @NotEmpty(message = "user last name not be null or empty")
    private String lastName;

    @NotEmpty(message = "user email not be null or empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message ="user insuranceProvider not be null or empty" )
    private String insuranceProvider;

    @NotEmpty(message = "user user aadhaarNumber not be null or empty")
    private String aadhaarNumber;

    @NotEmpty
    @Pattern(regexp = "^[0-9]{10}$", message = "phone must be 10 digits")
    private String mobileNumber;


}
