package com.petStore.dto;

import com.petStore.Entity.Money;
import lombok.Getter;

@Getter
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private Money budget;

    public UserDTO(String firstName, String lastName, String email, Money budget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.budget = budget;
    }
}
