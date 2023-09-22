package com.petStore.controller;

import com.petStore.Entity.Pet;
import com.petStore.dto.PetDTO;
import com.petStore.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetService petService;
    @PostMapping("/createPets")
    public ResponseEntity<List<Pet>> createPets(@RequestBody List<PetDTO> pets) {
        return petService.createPets(pets);
    }

    @GetMapping("/allPets")
    public ResponseEntity<List<PetDTO>> listPets() {
        return petService.getAllPets();
    }
}
