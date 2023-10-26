package com.petStore.controller.mapper.implementation;

import com.petStore.exception.UnsupportedTypeException;
import com.petStore.model.Cat;
import com.petStore.model.Dog;
import com.petStore.model.Pet;
import com.petStore.controller.mapper.GeneralMapper;
import com.petStore.dto.PetDTO;
import org.springframework.stereotype.Component;

@Component
public class PetMapper implements GeneralMapper<Pet, PetDTO> {
    @Override
    public PetDTO entityToDto(Pet pet) {
        if (pet instanceof Dog) {
            return new PetDTO(pet.getName(), pet.getType(), pet.getDescription(), pet.getDateOfBirth(),
                    pet.getPrice(), ((Dog) pet).getRating());
        } else {
            return new PetDTO(pet.getName(), pet.getType(), pet.getDescription(), pet.getDateOfBirth(),
                    pet.getPrice());
        }

    }

    @Override
    public Pet dtoToEntity(PetDTO petDTO) {
        if (petDTO.getType().equalsIgnoreCase("cat")) {
            return new Cat(petDTO.getName(), petDTO.getDescription(),
                    petDTO.getDateOfBirth());
        } else if (petDTO.getType().equalsIgnoreCase("dog") ) {
            return new Dog(petDTO.getName(), petDTO.getType(), petDTO.getDescription(),
                    petDTO.getDateOfBirth(), petDTO.getRating());
        }
        throw new UnsupportedTypeException("Unknown pet type");
    }
}
