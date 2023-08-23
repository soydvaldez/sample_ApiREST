package com.mysql.demo.api.orders.controller;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class OrderIO implements Serializable {
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String ciudad;
    private int codigoPostal;
    private String colonia;
    private String domicilio;
    private String estado;
    private LocalDateTime fechaPedido;
    private String referencias;

    public OrderIO() {
    }
}
