package com.example.shop.entity;

import lombok.Data;
import javax.validation.constraints.Min;
import javax.persistence.*;
import java.util.Date;

@Entity(name = "cartitem")
@Table(name = "cartitem")
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartitemID;
    @Min(value = 0,message = "Số lượng phải không âm")
    @Column(nullable = false)
    private int quantity;
    @Basic
    @Column(nullable = false)
    private Date createdAt;
    @Basic
    @Column(nullable = false)
    private Date updatedAt;



}
