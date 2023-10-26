package com.petStore.controller;

import com.petStore.dto.UserDTO;
import com.petStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<List<UserDTO>> createUsers(@RequestBody List<UserDTO> users) {
        return userService.createUsers(users);
    }
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> listUsers() {
        return  userService.getAllUsers();
    }

}
