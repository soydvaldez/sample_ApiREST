package com.mysql.demo.api.common.io;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class GenericResponseError implements Serializable {
    private Timestamp timestamp;
    private int status;
    private String error;
    private String Path;
}
