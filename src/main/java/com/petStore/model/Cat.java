package com.petStore.model;

import com.petStore.service.implementation.CalculatePrice;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Getter
@NoArgsConstructor
public class Cat extends Pet implements CalculatePrice {
    public Cat(String name, String type, String description, LocalDate dateOfBirth) {
        super(name, type, description, dateOfBirth, 0);
        this.price = calculatePrice();
    }

    public Cat(String name, String description, LocalDate dateOfBirth) {
        super(name, description, dateOfBirth);
    }

    @Override
    public double calculatePrice() {
        return Period.between(this.getDateOfBirth(), LocalDate.now()).getYears();
    }
}
