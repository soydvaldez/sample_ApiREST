package com.mysql.demo.api.common;

import com.mysql.demo.api.products.repository.Product;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class GenericResponse<Entity> {
    private Timestamp timestamp;
    private int status;
    private String message;
    private String Path;
    private Iterable<Entity> result;
}
