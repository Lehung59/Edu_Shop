package com.example.shop.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity(name = "orderdetail")
@Table(name = "orderdetail")
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderdetailID;
    @Basic
    @Column(nullable = false)
    private double pricetotal;
    @Basic
    @Column(nullable = false)
    @Min(value = 0,message = "Số lượng mua phải lớn hơn 0")
    private int quantity;
    @Basic
    @Column(nullable = false)
    private Date createdAt;
    @Basic
    @Column(nullable = false)
    private Date updatedAt;

}
