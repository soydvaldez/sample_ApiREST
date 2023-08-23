package com.mysql.demo.api.products.controller;

import lombok.Data;

@Data
public class ProductIO {

        private String nombre;
        private double number;
        private int stock;
        private String descripcion;
        private String categoria;
        private String tipo;

        public ProductIO() {
        }
}
