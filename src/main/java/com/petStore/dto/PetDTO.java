package com.petStore.dto;

import com.petStore.model.Pet;
import com.petStore.model.User;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PetDTO {
    private Integer id;
    private User owner;
    private String name;
    private Pet.Type type;
    private String description;
    private LocalDate dateOfBirth;
    private int price;
    private int rating;

    public PetDTO(Integer id, String name, Pet.Type type, String description, LocalDate dateOfBirth, int price, int rating) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
        this.price = price;
        this.rating = rating;
    }
}
