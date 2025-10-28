package com.sumanth.fundamentals_of_springboot.project1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateResponseDto {

    private Long id;
    private String aadhaarNumber;
    private String status;


}
