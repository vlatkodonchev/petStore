package com.petStore.service.implementation;

import com.petStore.exception.ResourceNotFoundException;
import com.petStore.model.HistoryLog;
import com.petStore.model.Pet;
import com.petStore.model.User;
import com.petStore.repository.HistoryLogRepository;
import com.petStore.repository.PetRepository;
import com.petStore.repository.UserRepository;
import com.petStore.service.PurchasePetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PurchasePetServiceImpl implements PurchasePetService {

    @Autowired
    PetRepository petRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    HistoryLogRepository historyLogRepository;

    @Transactional
    @Override
    public HistoryLog purchasePets() {
        List<Pet> allPets = petRepository.findAll();
        List<User> allUsers = userRepository.findAll();

        if (allPets.isEmpty() || allUsers.isEmpty()) {
            throw new ResourceNotFoundException("No user or no pet is found");
        }
        HistoryLog historyLog = new HistoryLog();
        int countSuccessfulAttempt = 0;
        int countFailedAttempt = 0;
        for (User user : allUsers) {
            boolean petSuccessfullyBought = false;
            for (Pet pet : allPets) {
                if (pet.getOwner() == null && user.getBudget() >= pet.getPrice()) {
                    pet.setOwner(user);
                    user.setBudget(user.getBudget() - pet.getPrice());
                    petSuccessfullyBought = true;
                    if (pet.getType().equals(Pet.Type.Cat)) {
                        System.out.println("Meow, cat " + pet.getName()
                                + " has owner " + user.getFirstName()
                                + " " + user.getLastName());
                    } else {
                        System.out.println("Woof, dog " + pet.getName()
                                + " has owner " + user.getFirstName()
                                + " " + user.getLastName());
                    }
                }
            }
            if (petSuccessfullyBought) {
                historyLog.setSuccessfulPurchases(++countSuccessfulAttempt);
            } else {
                historyLog.setFailedPurchases(++countFailedAttempt);
            }
        }
        historyLog.setDate(LocalDate.now());
        userRepository.saveAll(allUsers);
        petRepository.saveAll(allPets);
        historyLogRepository.save(historyLog);
        return historyLog;
    }
}
