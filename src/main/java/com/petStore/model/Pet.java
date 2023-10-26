package com.petStore.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User owner;

    @NonNull
    private String name;

    @NonNull
    private String type;

    private String description;

    @NonNull
    private LocalDate dateOfBirth;

    protected double price;

    public Pet(User owner, String name, String description, LocalDate dateOfBirth, double price) {
        this.owner = owner;
        this.name = name;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
        this.price = price;
    }

    public Pet(String name, String type, String description, LocalDate dateOfBirth, double price) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
        this.price = price;
    }

    public Pet(String name, String description, LocalDate dateOfBirth) {
        this.name = name;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
    }
}
