package com.example.shop.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {
    private double pricetotal;
    private int quantity;
    private String  email;
    private String productname;
    private String status;
    private String paymentmethod;

}
