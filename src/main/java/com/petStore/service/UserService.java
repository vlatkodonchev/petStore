package com.petStore.service;

import com.petStore.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    ResponseEntity<List<UserDTO>> createUsers(List<UserDTO> users);

    ResponseEntity<List<UserDTO>> getAllUsers();
}
