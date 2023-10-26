package com.petStore.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PetDTO {

    @NonNull
    private String name;

    @NonNull
    private String type;

    private String description;

    @NonNull
    private LocalDate dateOfBirth;

    private double price;

    private int rating;

    public PetDTO(String name, String type, String description, LocalDate dateOfBirth, double price, int rating) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
        this.price = price;
        this.rating = rating;
    }

    public PetDTO(String name, String type, String description, LocalDate dateOfBirth, double price) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
        this.price = price;
    }
}
