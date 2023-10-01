package com.petStore.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class UserDTO {
    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    @Column(unique = true)
    private String email;

    private int budget;

    public UserDTO(String firstName, String lastName, String email, int budget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.budget = budget;
    }
}
