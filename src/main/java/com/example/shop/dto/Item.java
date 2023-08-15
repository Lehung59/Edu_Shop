package com.example.shop.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Item {
    private String productname;
    private int quantity;
    private Date createdAt;
}
