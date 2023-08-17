package com.mysql.demo.controller;

import lombok.Data;
import java.io.Serializable;
@Data
public class Request implements Serializable {
        public UserRequest user;

        public Request() {
        }
}


