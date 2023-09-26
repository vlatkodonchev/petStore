package com.petStore.service.implementation;

import com.petStore.model.Pet;
import com.petStore.controller.mapper.implementation.PetMapper;
import com.petStore.dto.PetDTO;
import com.petStore.repository.PetRepository;
import com.petStore.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    PetRepository petRepository;
    @Autowired
    PetMapper petMapper;

    @Override
    public ResponseEntity<List<Pet>> createPets(List<PetDTO> petsDTO) {
        if (!petsDTO.isEmpty() && petsDTO.size() <= 20) {
            List<Pet> pets = new ArrayList<>();
            for (PetDTO petDTO : petsDTO) {
                Pet pet = petMapper.dtoToEntity(petDTO);
                if (pet.checkRatingRange()) {
                    return new ResponseEntity<>(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
                }
                pet.calculatePrice();
                pets.add(pet);
            }
            petRepository.saveAll(pets);
            return new ResponseEntity<>(pets, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<PetDTO>> getAllPets() {
        List<Pet> pets = petRepository.findAll();
        if (!pets.isEmpty()) {
            List<PetDTO> petDTOList = pets.stream()
                    .map(pet -> petMapper.entityToDto(pet))
                    .toList();
            return new ResponseEntity<>(petDTOList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
