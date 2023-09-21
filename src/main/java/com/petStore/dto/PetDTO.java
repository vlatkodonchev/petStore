package com.petStore.dto;

import com.petStore.Entity.Money;
import com.petStore.Entity.Pet;
import com.petStore.Entity.User;

import java.util.Date;

public class PetDTO {
    private User owner;
    private String name;
    private Pet.Type type;
    private String description;
    private Date dateOfBirth;
    private Money price;
}
