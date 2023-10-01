package com.petStore.service.implementation;

import com.petStore.exception.ResourceNotFoundException;
import com.petStore.model.User;
import com.petStore.controller.mapper.implementation.UserMapper;
import com.petStore.dto.UserDTO;
import com.petStore.repository.UserRepository;
import com.petStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Transactional
    @Override
    public ResponseEntity<List<UserDTO>> createUsers(List<UserDTO> usersDto) {
        if (!usersDto.isEmpty() && usersDto.size() <= 10) {
            List<User> users = usersDto.stream()
                    .map(userDto -> userMapper.dtoToEntity(userDto))
                    .toList();
            userRepository.saveAll(users);
            return new ResponseEntity<>(usersDto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = userRepository.findAll();

//      different approach with returning custom exception
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("No users found");
        }

        List<UserDTO> userDTOList = users.stream()
                .map(user -> userMapper.entityToDto(user))
                .toList();
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }
}
