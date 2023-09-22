package com.petStore.service.implementation;

import com.petStore.Entity.Pet;
import com.petStore.Entity.User;
import com.petStore.controller.mapper.implementation.UserMapper;
import com.petStore.dto.UserDTO;
import com.petStore.repository.PetRepository;
import com.petStore.repository.UserRepository;
import com.petStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PetRepository petRepository;
    @Autowired
    UserMapper userMapper;

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

        if (!users.isEmpty()) {
            List<UserDTO> userDTOList = users.stream().map(user -> userMapper.entityToDto(user)).toList();
            return new ResponseEntity<>(userDTOList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void buyPet() {
        List<User> allUsers = userRepository.findAll();
        List<Pet> allPets = petRepository.findAll();
        if (!allUsers.isEmpty() || !allPets.isEmpty()) {
            for (Pet pet : allPets) {
                for (User user : allUsers) {
                    if (pet.getOwner() == null && user.getBudget() >= pet.getPrice()) {
                        pet.setOwner(user);
                        user.setBudget(user.getBudget() - pet.getPrice());
                    }
                }
            }
            userRepository.saveAll(allUsers);
            petRepository.saveAll(allPets);
        }
    }
}
