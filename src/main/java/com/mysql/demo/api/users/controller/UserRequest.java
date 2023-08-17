package com.mysql.demo.api.users.controller;

import lombok.Data;
import java.io.Serializable;
import com.mysql.demo.api.users.common.UserBase;

@Data
public class UserRequest extends UserBase implements Serializable {
    public UserRequest() {
        super();
    }
}
