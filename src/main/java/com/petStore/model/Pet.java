package com.petStore.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
@Data
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User owner;

    @NonNull
    private String name;

    // This can be also implemented with creating two separate classes(Dog and Cat) which will extend the Pet class
    // and the Dog class will have separate property rating
    @Enumerated(EnumType.STRING)
    @NonNull
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
        //cats don`t have rating, so we set it to 0
        if (this.type.equals(Type.Cat)) {
            this.rating = 0;
            return false;
        }
        return this.rating > 10 || this.rating < 0;
    }
}
