package com.petStore.service;

import com.petStore.model.Pet;
import com.petStore.dto.PetDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PetService {
    ResponseEntity<List<Pet>> createPets(List<PetDTO> pets);

    ResponseEntity<List<PetDTO>> getAllPets();
}
