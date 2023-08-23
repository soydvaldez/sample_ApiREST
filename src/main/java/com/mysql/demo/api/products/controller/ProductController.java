package com.mysql.demo.api.products.controller;

import com.mysql.demo.api.common.GenericResponse;
import com.mysql.demo.api.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@Controller
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/all")
    public @ResponseBody ResponseEntity<?> getAll() {
        Iterable<ProductIO> products = productService.getAll();
        GenericResponse<ProductIO> response = new GenericResponse();

        response.setTimestamp(new Timestamp(System.currentTimeMillis()));
        response.setStatus(200);
        response.setMessage("Request: OK");
        response.setPath("/products/all");
        response.setResult(products);
        return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> add(@RequestBody ProductIO product) {
        productService.newProduct(product);
        return new ResponseEntity<String>("Request accepted by server", HttpStatus.CREATED);
    }
}

