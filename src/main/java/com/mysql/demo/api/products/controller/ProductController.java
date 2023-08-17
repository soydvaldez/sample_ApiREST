package com.mysql.demo.api.products.controller;

import com.mysql.demo.api.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @CrossOrigin(origins = {"http://localhost:4200", "http://192.168.1.174:4200"})
    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {

        return new ResponseEntity<String>("response", HttpStatus.ACCEPTED);
    }
}
