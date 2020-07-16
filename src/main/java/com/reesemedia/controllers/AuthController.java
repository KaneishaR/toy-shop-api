package com.reesemedia.controllers;

import com.reesemedia.dtos.Credentials;
import com.reesemedia.entities.AppUsers;
import com.reesemedia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    UserService userService;

    @Autowired
    AuthController(UserService service){
        this.userService = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AppUsers authenticate(@RequestBody Credentials credentials){
        return userService.authenticate(credentials);
    }
}
