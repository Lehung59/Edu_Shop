package com.example.shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "carts")
@Table(name = "carts")
@Data
public class Carts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartID;
    @Basic
    @Column(nullable = false)
    private Date createdAt;
    @Basic
    @Column(nullable = false)
    private Date updatedAt;


}
