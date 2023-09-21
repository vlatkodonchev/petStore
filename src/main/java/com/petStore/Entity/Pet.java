package com.petStore.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table
@Data
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private User owner;
    private String name;
    private Type type;
    private String description;
    private Date dateOfBirth;
    private Money price;


    public enum Type {
        Cat, Dog;
    }
}
