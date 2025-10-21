package com.sumanth.fundamentals_of_springboot.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema
public class UserCreateRequestDto {

    //user first name not be null or empty
    @Schema(name = "firstName",description = "user first name not be null or empty")
    @NotEmpty(message = "user first name not be null or empty")
    private String firstName;

    //user lastName  not be null or empty
    @Schema(name = "lastName",description = "user last name not be null or empty")
    @NotEmpty(message = "user last name not be null or empty")
    private String lastName;

    @Schema(name = "email",description = "user email name not be null or empty")
    @NotEmpty(message = "user email not be null or empty")
    @Email(message = "Email should be valid")
    private String email;

    @Schema(name = "insuranceProvider",description = "user insuranceProvider name not be null or empty")
    @NotEmpty(message ="user insuranceProvider not be null or empty" )
    private String insuranceProvider;

    @Schema(name = "aadhaarNumber",description = "user aadhaarNumber name not be null or empty")
    @NotEmpty(message = "user user aadhaarNumber not be null or empty")
    private String aadhaarNumber;

    @Schema(name = "mobileNumber",description = "user phone number must be 10 digits and not be null or empty ")
    @NotEmpty
    @Pattern(regexp = "^[0-9]{10}$", message = "phone must be 10 digits")
    private String mobileNumber;


}
