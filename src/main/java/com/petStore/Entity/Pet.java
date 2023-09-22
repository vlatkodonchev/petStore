package com.petStore.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
@Data
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private User owner;
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String description;
    private LocalDate dateOfBirth;
    private int price;
    private int rating;


    public Pet(User owner, String name, Type type, String description, LocalDate dateOfBirth, int price, int rating) {
        this.owner = owner;
        this.name = name;
        this.type = type;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
        this.price = price;
        this.rating = rating;
    }

    public enum Type {
        Cat, Dog
    }

    public void calculatePrice() {
        if (this.type.equals(Type.Cat)) {
            this.price = Period.between(dateOfBirth, LocalDate.now()).getYears();
        } else {
            this.price = (Period.between(dateOfBirth, LocalDate.now()).getYears()) + rating;
        }
    }

    public boolean checkRatingRange() {
        return this.rating > 10 || this.rating < 0;
    }
}
