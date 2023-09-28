package com.petStore.controller;

import com.petStore.model.HistoryLog;
import com.petStore.service.PurchasePetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchasePetService purchasePetService;
    @PostMapping("/buyPets")
    public ResponseEntity<HistoryLog> buyPet() {
        return new ResponseEntity<>(purchasePetService.purchasePets(), HttpStatus.OK);
    }
}
