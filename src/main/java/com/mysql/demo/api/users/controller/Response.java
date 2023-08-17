package com.mysql.demo.api.users.controller;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
class Response implements Serializable {
    private Timestamp timestamp;
    public boolean error;
    public String message;
}
