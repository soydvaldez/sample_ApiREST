package com.mysql.demo.api.users.service;

import com.mysql.demo.api.users.controller.UserRequest;
import com.mysql.demo.api.users.repository.User;
import com.mysql.demo.api.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository; // This means to get the bean called userRepository

    public String newUser(UserRequest userRequest) {
        //Logica del negocio: Calcula la edad del usuario.
        userRepository.save(this.parseToDataModel(userRequest));
        return "Se guardo";
    }

    private User parseToDataModel(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setBirthday(userRequest.getBirthday());
        user.setAge(userRequest.getAge());
        return user;
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }
}
