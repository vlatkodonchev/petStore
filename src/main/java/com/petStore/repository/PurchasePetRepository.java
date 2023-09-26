package com.petStore.repository;

import com.petStore.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasePetRepository extends JpaRepository<Pet, Integer> {
}
