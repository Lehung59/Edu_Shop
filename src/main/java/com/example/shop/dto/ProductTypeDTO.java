package com.example.shop.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductTypeDTO {
    private String producttypename;
    private String producttypeimg;
    List<ProductDTO> productDTOS;

}
