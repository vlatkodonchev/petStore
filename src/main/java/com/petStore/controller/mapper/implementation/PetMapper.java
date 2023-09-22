package com.petStore.controller.mapper.implementation;

import com.petStore.Entity.Pet;
import com.petStore.controller.mapper.GeneralMapper;
import com.petStore.dto.PetDTO;
import org.springframework.stereotype.Component;

@Component
public class PetMapper implements GeneralMapper<Pet, PetDTO> {
    @Override
    public PetDTO entityToDto(Pet pet) {
        return new PetDTO(pet.getId(), pet.getName(), pet.getType(), pet.getDescription(), pet.getDateOfBirth(),
                pet.getPrice(), pet.getRating());
    }

    @Override
    public Pet dtoToEntity(PetDTO petDTO) {
        return new Pet(petDTO.getOwner(), petDTO.getName(), petDTO.getType(), petDTO.getDescription(),
                petDTO.getDateOfBirth(), petDTO.getPrice(), petDTO.getRating());
    }
}
