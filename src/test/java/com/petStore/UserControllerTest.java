package com.petStore;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petStore.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
        User user1 = new User("", "", "");
        User user2 = new User("", "", "");
        List<User> users = new ArrayList<>(Arrays.asList(user1,user2));

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/user/createUsers")
                        .content(asJsonString(users))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)).andReturn();
    }
    private static String asJsonString(final List<User> users) {
        try {
            return new ObjectMapper().writeValueAsString(users);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
