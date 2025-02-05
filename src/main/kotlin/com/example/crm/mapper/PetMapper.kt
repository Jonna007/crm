package com.example.crm.mapper

import com.example.crm.dto.PetDTO
import com.example.crm.dto.CreatePetDTO
import com.example.crm.entity.Pet
import com.example.crm.entity.User
import org.springframework.stereotype.Component

@Component
class PetMapper {
    fun toEntity(dto: CreatePetDTO, user: User): Pet =
        Pet(
            name = dto.name,
            species = dto.species,
            breed = dto.breed,
            age = dto.age,
            ownerdName = dto.ownerdName,
            user = user
        )

    fun toDTO(entity: Pet): PetDTO =
        PetDTO(
            id = entity.id,
            name = entity.name,
            species = entity.species,
            breed = entity.breed,
            age = entity.age,
            ownerdName = entity.ownerdName,
            userId = entity.user.id
        )
}

