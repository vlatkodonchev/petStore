package com.petStore.repository;

import com.petStore.Entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {

}
