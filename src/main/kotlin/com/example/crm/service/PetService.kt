package com.example.crm.service

import com.example.crm.dto.CreatePetDTO
import com.example.crm.dto.PetDTO
import com.example.crm.mapper.PetMapper
import com.example.crm.repository.PetRepository
import com.example.crm.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PetService(
    private val petRepository: PetRepository,
    private val userRepository: UserRepository,
    private val petMapper: PetMapper
) {
    @Transactional
    fun createPet(createPetDTO: CreatePetDTO): PetDTO {
        val user = userRepository.findById(createPetDTO.userId)
            .orElseThrow { NoSuchElementException("User not found with id: ${createPetDTO.userId}") }

        val pet = petMapper.toEntity(createPetDTO, user)
        val savedPet = petRepository.save(pet)
        return petMapper.toDTO(savedPet)
    }

    @Transactional(readOnly = true)
    fun getPetsByUserId(userId: Long): List<PetDTO> {
        return petRepository.findAllByUserId(userId)
            .map { petMapper.toDTO(it) }
    }
}

