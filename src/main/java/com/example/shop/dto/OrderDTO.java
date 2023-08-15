package com.example.shop.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private String email;

    private List<OrderDetailDTO> orderDetailDTOS;
}
