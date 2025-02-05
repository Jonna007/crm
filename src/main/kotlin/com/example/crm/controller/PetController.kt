package com.example.crm.controller

import com.example.crm.dto.CreatePetDTO
import com.example.crm.dto.PetDTO
import com.example.crm.service.PetService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/pets")
class PetController(private val petService: PetService) {

    @PostMapping
    fun createPet(@RequestBody createPetDTO: CreatePetDTO): ResponseEntity<PetDTO> {
        val petDTO = petService.createPet(createPetDTO)
        return ResponseEntity(petDTO, HttpStatus.CREATED)
    }

    @GetMapping("/user/{userId}")
    fun getPetsByUserId(@PathVariable userId: Long): ResponseEntity<List<PetDTO>> {
        val pets = petService.getPetsByUserId(userId)
        return ResponseEntity.ok(pets)
    }
}

