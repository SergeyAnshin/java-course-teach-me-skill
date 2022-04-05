package com.ans.serg.swaggerpetstore.controller;

import com.ans.serg.swaggerpetstore.entity.Pet;
import com.ans.serg.swaggerpetstore.enums.PetStatus;
import com.ans.serg.swaggerpetstore.service.PetService;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * add exceptons
 * findByStatus доделать
 */
@RestController
@RequestMapping("/pet")
@Api(value = "pet", description = "Everything about your Pets")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    @ApiOperation(value = "Add a new pet to the store")
    @ApiImplicitParam(name = "pet", value = "Pet object that needs to be added to the store")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
//    @ApiImplicitParam(name = "body", value = "Pet object that needs to be added to the store", required = true, dataType = "Integer", paramType = "body")
    public ResponseEntity<Pet> save(@Valid @RequestBody Pet pet) {
        Pet savedPet = petService.save(pet);
        return ResponseEntity.ok(savedPet);
    }

    @PutMapping
    public ResponseEntity<Pet> update(@RequestBody Pet pet) {
        Pet updatedPet = petService.update(pet);
        return ResponseEntity.ok(updatedPet);
    }

    @GetMapping("/findByStatus")
    public ResponseEntity<List<Pet>> findByStatus(@RequestBody List<PetStatus> petStatuses) {
        List<Pet> foundPets = petService.findByStatus(petStatuses);
        return ResponseEntity.ok(foundPets);
    }

    @GetMapping("/{petId}")
    public ResponseEntity<Pet> findById(@PathVariable long petId) {
        Optional<Pet> foundPet = petService.findById(petId);
        return ResponseEntity.ok(foundPet.get());
    }

    @PostMapping("/{petId}")
    public ResponseEntity<Object> updateWithForm(@RequestBody Pet pet, @PathVariable long petId) {
        boolean updatedPet = petService.updateNameAndStatusById(pet);
        return ResponseEntity.ok("dm");
    }

    @DeleteMapping("/{petId}")
    public void deleteById(@PathVariable long petId) {
        petService.deleteById(petId);
    }
}
