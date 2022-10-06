package com.example.demo.service;

import com.example.demo.data.dto.ProductDto;

public interface ProductService {

    // ProductDto 리턴해주는 메소드
    ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);

    ProductDto getProduct(String productId);

}