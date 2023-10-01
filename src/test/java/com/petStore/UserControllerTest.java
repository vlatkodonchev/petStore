package com.petStore;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petStore.controller.mapper.implementation.UserMapper;
import com.petStore.dto.UserDTO;
import com.petStore.model.User;
import com.petStore.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserMapper userMapper;

    @MockBean
    private UserService userService;

    @Test
    public void getAllUsersTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/user/allUsers")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void createUserTest() throws Exception {
        User user1 = new User("Name1", "LastName1", "name1@gmail.com");
        User user2 = new User("Name2", "LastName1", "name2@gmail.com");
        List<User> users = new ArrayList<>(Arrays.asList(user1, user2));

        List<UserDTO> usersDto = users.stream()
                .map(user -> userMapper.entityToDto(user))
                .toList();

        Mockito.when(userService.createUsers(Mockito.any()))
                .thenReturn(new ResponseEntity<>(usersDto, HttpStatus.CREATED));

        mockMvc.perform(MockMvcRequestBuilders
                .post("/user/createUsers")
                .content(asJsonString(users))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("[0].firstName").value("Name1"));
    }

    private static String asJsonString(final List<User> users) {
        try {
            return new ObjectMapper().writeValueAsString(users);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
