package com.petStore.dto;

import lombok.Getter;

@Getter
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private int budget;

    public UserDTO(String firstName, String lastName, String email, int budget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.budget = budget;
    }
}
