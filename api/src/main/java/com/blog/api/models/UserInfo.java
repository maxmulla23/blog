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


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private  UserEntity user;
}
