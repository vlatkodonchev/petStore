package com.petStore.service.implementation;

import com.petStore.model.Dog;
import com.petStore.model.Pet;
import com.petStore.controller.mapper.implementation.PetMapper;
import com.petStore.dto.PetDTO;
import com.petStore.repository.PetRepository;
import com.petStore.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    PetRepository petRepository;
    @Autowired
    PetMapper petMapper;

    @Transactional
    @Override
    public List<Pet> createPets(List<PetDTO> petsDTO) {
        if (!petsDTO.isEmpty() && petsDTO.size() <= 20) {
            List<Pet> pets = new ArrayList<>();
            for (PetDTO petDTO : petsDTO) {
                Pet pet = petMapper.dtoToEntity(petDTO);
                pets.add(pet);
            }
            petRepository.saveAll(pets);
            return pets;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<PetDTO> getAllPets() {
        List<Pet> pets = petRepository.findAll();
        if (!pets.isEmpty()) {
            List<PetDTO> petDTOList = pets.stream()
                    .map(pet -> petMapper.entityToDto(pet))
                    .toList();
            return petDTOList;
        } else {
            return new ArrayList<>();
        }
    }
}
