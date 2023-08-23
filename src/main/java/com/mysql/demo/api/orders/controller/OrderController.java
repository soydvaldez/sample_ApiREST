package com.mysql.demo.api.orders.controller;

import com.mysql.demo.api.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping(path = "/add")
    public @ResponseBody ResponseEntity<?> add(@RequestBody OrderIO order) {

        return new ResponseEntity<String>("Resource has been crerated", HttpStatus.CREATED);
    }
}
