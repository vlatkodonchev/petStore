package com.petStore.service.implementation;

import com.petStore.Entity.User;
import com.petStore.controller.mapper.implementation.UserMapper;
import com.petStore.dto.UserDTO;
import com.petStore.repository.UserRepository;
import com.petStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    @Override
    public ResponseEntity<List<UserDTO>> createUsers(List<UserDTO> usersDto) {
        if (!usersDto.isEmpty() && usersDto.size() < 10) {
            List<User> users = usersDto.stream()
                    .map(userDto -> userMapper.dtoToEntity(userDto))
                    .toList();
            userRepository.saveAll(users);
            return new ResponseEntity<>(usersDto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
