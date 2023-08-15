package com.example.shop.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "ordertbl")
@Table(name = "ordertbl")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;
    @Basic
    @Column(nullable = false)
    private double originalprice= 0;
    @Basic
    @Column(nullable = false)
    private double actualprice= 0;
    @Basic
    @Column(nullable = false)
    private Date createdAt;
    @Basic
    @Column(nullable = false)
    private Date updatedAt;

}
