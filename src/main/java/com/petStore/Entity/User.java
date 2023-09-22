package com.petStore.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "owner")
    private List<Pet> petsOwned;
    private String firstName;
    private String lastName;
    private String email;
    private int budget;

    public User(String firstName, String lastName, String email, int budget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.budget = budget;
    }
}
