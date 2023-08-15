package com.example.shop.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity(name = "importdt")
@Table(name = "importdt")
@Data
public class ImportDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int ID;
    @Column(nullable = false)
    @Min(value = 1)
    private int quantity;
    @Column(nullable = false)
    private Date createdAt;
    @Basic
    @Column(nullable = false)
    private Date updatedAt;
    @Basic
    @Column(nullable = false)
    private double pricetotal;
    @Basic
    @Column(nullable = false)
    private double price;

}
