package com.mysql.demo.service;

import com.mysql.demo.controller.UserRequest;
import com.mysql.demo.repository.User;
import com.mysql.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository; // This means to get the bean called userRepository

    public String newUser(UserRequest user){
        // Logica del negocio
        //Calcula la edad del usuario
        return "Se guardo";
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }
}
