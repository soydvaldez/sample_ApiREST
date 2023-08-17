package com.mysql.demo.controller;

import com.mysql.demo.repository.User;
import com.mysql.demo.repository.UserRepository;
import com.mysql.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.regex.Pattern;

@Controller
@RequestMapping(path="/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path="/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addNewUser(@RequestBody Request request) {
        UserRequest inputUser = request.getUser();

        if(inputUser.getUsername() == null  || inputUser.getEmail() == null){
            GenericResponseError response = new GenericResponseError();
            response.setTimestamp(new Timestamp(System.currentTimeMillis()));
            response.setStatus(400);
            response.setError("Bad Request: Verify body content: username or email is missing or both");
            response.setPath("/users/add");
            return new ResponseEntity<GenericResponseError>(response, HttpStatus.BAD_REQUEST);
        }

        if(inputUser.getUsername().isEmpty() || inputUser.getEmail().isEmpty()){
            GenericResponseError response = new GenericResponseError();
            response.setTimestamp(new Timestamp(System.currentTimeMillis()));
            response.setStatus(400);
            response.setError("Bad Request: Verify body content: username or email is empty");
            response.setPath("/users/add");
            return new ResponseEntity<GenericResponseError>(response, HttpStatus.BAD_REQUEST);
        }

        //Verify input data form
        if(!isMatchAEmail(inputUser.getEmail())){
            GenericResponseError response = new GenericResponseError();
            response.setTimestamp(new Timestamp(System.currentTimeMillis()));
            response.setStatus(400);
            response.setError("Bad Request: Email field not corresponding a email");
            response.setPath("/users/add");
            return new ResponseEntity<GenericResponseError>(response, HttpStatus.BAD_REQUEST);
        }

        //  User newUser = new User();
        //  newUser.setUsername(inputUser.getUsername());
        //  newUser.setEmail(inputUser.getEmail());

        try {
            String isSaved = userService.newUser(inputUser);
            Response response = new Response();
            response.setTimestamp(new Timestamp(System.currentTimeMillis()));
            response.setError(false);
            response.setMessage("User has been saved with successful");
            return new ResponseEntity<Response>(response, HttpStatus.CREATED);
        } catch (IllegalArgumentException ex){
            GenericResponseError response = new GenericResponseError();
            response.setTimestamp(new Timestamp(System.currentTimeMillis()));
            response.setStatus(500);
            response.setError("Oppps something going wrong with the server!");
            response.setPath("/users/add");
            return new ResponseEntity<GenericResponseError>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userService.getAll();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/resource",produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGretting() {
        // This returns a JSON or XML with the users
        Response response = new Response();
        response.setMessage("Hola mundo");
        return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
    }

    public boolean isMatchAEmail(String email) {
        String regexPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(regexPattern, email);
    }
}