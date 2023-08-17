package com.mysql.demo.api.users.controller;

import lombok.Data;
import java.io.Serializable;
@Data
public class Request implements Serializable {
        public UserRequest user;

        public Request() {
        }
}


