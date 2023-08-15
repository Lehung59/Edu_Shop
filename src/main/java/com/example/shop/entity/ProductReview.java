package com.example.shop.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity(name = "productreview")
@Table(name = "productreview")
@Data
public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productreviewID;
    @Basic
    @Column
    private String contentrated;
    @Basic
    @Min(value = 1,message = "Thấp nhất là 1 điểm")
    @Max(value = 10,message = "Cao nhất là 10 điểm.Không có nhưng hehe")
    @Column(nullable = false)
    private int pointevaluation;
    @Basic
    @Column
    private String contentseen;
    @Basic
    @Column(nullable = false)
    private int status;
    @Basic
    @Column(nullable = false)
    private Date createdAt;
    @Basic
    @Column(nullable = false)
    private Date updatedAt;

}
