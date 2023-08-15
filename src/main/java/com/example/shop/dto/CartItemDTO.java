package com.example.shop.dto;


import lombok.Data;

@Data
public class CartItemDTO {
    private int quantity;
    private ProductDTO productDTO;
    private CartsDTO cartsDTO;

}
