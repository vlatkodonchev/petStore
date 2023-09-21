package com.petStore.controller;

import com.petStore.Entity.User;
import com.petStore.dto.UserDTO;
import com.petStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/createUsers")
    public ResponseEntity<List<UserDTO>>createUsers(@RequestBody List<UserDTO> users) {
        return userService.createUsers(users);
    }
}
