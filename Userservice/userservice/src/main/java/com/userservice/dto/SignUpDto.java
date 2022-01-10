package com.userservice.dto;

import lombok.Data;

@Data
public class SignUpDto {
    
    private String username;
    private String email;
    private String password;
    private String phoneNo;
    private String address;
    
}