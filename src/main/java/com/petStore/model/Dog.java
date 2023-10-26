package com.petStore.model;

import com.petStore.service.implementation.CalculatePrice;
import com.petStore.service.implementation.CheckRating;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;


@Entity
@Getter
@NoArgsConstructor
public class Dog extends Pet implements CheckRating, CalculatePrice {

    private int rating;

    public Dog(int rating) {
        if (isRegularRating(rating)) {
            this.rating = rating;
        }
    }

    public Dog(String name, String type, String description, LocalDate dateOfBirth, int rating, int price) {
        super(name, type, description, dateOfBirth, price);
        if (isRegularRating(rating)) {
            this.rating = rating;
        }
    }

    public Dog(String name, String type, String description, LocalDate dateOfBirth, int rating) {
        super(name, type, description, dateOfBirth, 0.0);
        if (isRegularRating(rating)) {
            this.rating = rating;
            this.price = calculatePrice();
        }
    }

    @Override
    public boolean isRegularRating(int rating) {
        return rating > 0 && rating <= 10;
    }

    @Override
    public double calculatePrice() {
        return Period.between(this.getDateOfBirth(), LocalDate.now()).getYears() + rating;
    }
}
