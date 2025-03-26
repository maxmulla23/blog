package com.blog.api.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
}
