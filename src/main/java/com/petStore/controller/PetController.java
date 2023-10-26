package com.petStore.controller;

import com.petStore.model.Pet;
import com.petStore.dto.PetDTO;
import com.petStore.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetService petService;

    @PostMapping("/create")
    public ResponseEntity<List<Pet>> createPets(@RequestBody List<PetDTO> pets) {
        return new ResponseEntity<>(petService.createPets(pets), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PetDTO>> listPets() {
        return new ResponseEntity<>(petService.getAllPets(), HttpStatus.OK);
    }
}
