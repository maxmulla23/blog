package com.blog.api.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "userInfo")
@Data
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private String bio;


    @OneToOne(mappedBy = "userinfo")
    private  UserEntity user;
}
