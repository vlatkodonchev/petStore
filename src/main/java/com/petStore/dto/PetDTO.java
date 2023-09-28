package com.petStore.dto;

import com.petStore.model.Pet;
import com.petStore.model.User;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

@Getter
public class PetDTO {

    private Long id;

    private User owner;

    @NonNull
    private String name;

    @NonNull
    private Pet.Type type;

    private String description;

    private LocalDate dateOfBirth;

    private int price;

    private int rating;

    public PetDTO(String name, Pet.Type type, String description, LocalDate dateOfBirth, int price, int rating) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
        this.price = price;
        this.rating = rating;
    }
}
