package com.example.shop.login.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity(name = "account")
@Table(name = "account")
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountID;
    @Basic
    @Column(nullable = false, unique = true)
    private String username;
    @Basic
    @Column(nullable = false, unique = true)
    private String avatar;
    @Basic
    @Column(nullable = false)
    private String password;
    @Basic
    @Column(nullable = false)
    private int status;
    @Basic
    @Column(nullable = false)
    private Date createdAt;
    @Basic
    @Column(nullable = true)
    private Date updateAt;
    @Column(name = "enabled")
    private boolean enabled;

    public Account() {
        super();
        this.enabled = false;

    }
}