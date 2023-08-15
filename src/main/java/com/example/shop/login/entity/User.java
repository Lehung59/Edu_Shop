package com.example.shop.login.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity(name = "user")
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    @Basic
    @Size(min = 6, max = 30, message = "username từ 6-30 ký tự hợp lệ")
    @Column(nullable = false, unique = true)
    private String username;
    @Basic
    @Column(nullable = false)
    @Size(min = 10, max = 10, message = "Số điện thoại có định dạng 0xxxxxxxxx")
    private String phone;
    @Basic
    @Column(nullable = false, unique = true)
    private String email;
    @Basic
    @Column(nullable = false)
    private String address;
    @Basic
    @Column(nullable = false)
    private Date createdAt;
    @Basic
    @Column(nullable = false)
    private Date updateAt;
}