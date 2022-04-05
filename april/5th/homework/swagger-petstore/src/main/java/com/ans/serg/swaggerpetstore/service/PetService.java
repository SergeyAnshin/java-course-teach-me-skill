package com.ans.serg.swaggerpetstore.service;

import com.ans.serg.swaggerpetstore.entity.Pet;
import com.ans.serg.swaggerpetstore.enums.PetStatus;
import com.ans.serg.swaggerpetstore.exception.PetNotFoundException;
import com.ans.serg.swaggerpetstore.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet update(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> findByStatus(List<PetStatus> petStatuses) {
        return petRepository.findAllByStatusIn(petStatuses);
    }

    public Optional<Pet> findById(long petId) {
        Optional<Pet> pet = petRepository.findById(petId);
        if (pet.isPresent()) {
            return pet;
        } else {
            throw new PetNotFoundException(PetNotFoundException.DEFAULT_MESSAGE);
        }
    }

    public boolean updateNameAndStatusById(Pet pet) {
        return petRepository.updateNameAndStatusById(pet.getId(), pet.getName(), pet.getStatus()) > 0;
    }

    public void deleteById(long petId) {
       petRepository.deleteById(petId);
    }
}
