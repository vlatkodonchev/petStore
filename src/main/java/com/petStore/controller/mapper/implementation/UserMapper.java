package com.petStore.controller.mapper.implementation;

import com.petStore.model.User;
import com.petStore.controller.mapper.GeneralMapper;
import com.petStore.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements GeneralMapper<User, UserDTO> {
    @Override
    public UserDTO entityToDto(User user) {
        return new UserDTO(user.getFirstName(), user.getLastName(), user.getEmail(), user.getBudget());
    }

    @Override
    public User dtoToEntity(UserDTO userDTO) {
        return new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail(), userDTO.getBudget());
    }
}
