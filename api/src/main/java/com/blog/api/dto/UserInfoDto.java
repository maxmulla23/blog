package com.blog.api.dto;

import lombok.Data;

@Data
public class UserInfoDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String bio;

    public UserInfoDto(int id, String firstName, String lastName, String email, String bio) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.bio = bio;
    }

    public UserInfoDto() {

    }
}
