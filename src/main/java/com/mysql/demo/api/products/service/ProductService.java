package com.mysql.demo.api.products.service;

//import com.mysql.demo.api.products.repository.Product;

import com.mysql.demo.api.products.repository.Product;
import com.mysql.demo.api.products.repository.ProductRepository;
import com.mysql.demo.api.products.controller.ProductIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Iterable<ProductIO> getAll() {
        return this.productAdapter(productRepository.findAll());
    }

    public void newProduct(ProductIO product) {

    }

    public List<ProductIO> productAdapter(Iterable<Product> products) {
        List<ProductIO> list = new ArrayList<ProductIO>();
        Iterator<Product> it = products.iterator();
        while (it.hasNext()) {
            ProductIO tmp = new ProductIO();
            Product product = it.next();
            tmp.setNombre(product.getNombre());
            list.add(tmp);
        }
        return list;
    }
}
