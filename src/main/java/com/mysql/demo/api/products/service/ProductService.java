package com.mysql.demo.api.products.service;

import com.mysql.demo.api.products.repository.Product;
import com.mysql.demo.api.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }
}
