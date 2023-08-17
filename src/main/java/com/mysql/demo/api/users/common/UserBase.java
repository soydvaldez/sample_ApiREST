package com.mysql.demo.api.users.common;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
//Clase base para aplicar el patron adapter o pasar entre capas el objeto de negocio
public class UserBase {
    public String username;
    public String email;
    @JsonFormat(pattern = "yyyy/MM/dd/")
    public LocalDate birthday;
    public int age;

    public UserBase() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
