package com.mysql.demo;

import lombok.Data;
import java.io.Serializable;
@Data
public class Request implements Serializable {
        public UserTest user;

        public Request() {
        }
}

@Data
class UserTest {
    public String username;
    public String email;

    public UserTest() {
    }

    public UserTest(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
