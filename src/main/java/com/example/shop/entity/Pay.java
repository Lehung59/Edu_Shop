package com.example.shop.entity;


import lombok.Data;

import javax.persistence.*;

@Entity(name = "pay")
@Table(name = "pay")
@Data
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payID;
    @Column(nullable = false)
    private double originalprice= 0;

}
