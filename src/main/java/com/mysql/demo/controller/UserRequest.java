package com.mysql.demo.controller;

import lombok.Data;

@Data
public class UserRequest {
    public String username;
    public String email;

    public UserRequest() {
    }

    public UserRequest(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
