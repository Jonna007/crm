package com.example.crm.mapper

import com.example.crm.dto.VitalSignDTO
import com.example.crm.dto.CreateVitalSignDTO
import com.example.crm.entity.VitalSign
import com.example.crm.entity.Pet
import org.springframework.stereotype.Component

@Component
class VitalSignMapper {
    fun toEntity(dto: CreateVitalSignDTO, pet: Pet): VitalSign =
        VitalSign(
            temperature = dto.temperature,
            heartRate = dto.heartRate,
            date = dto.date,
            time = dto.time,
            device = dto.device,
            pet = pet
        )

    fun toDTO(entity: VitalSign): VitalSignDTO =
        VitalSignDTO(
            id = entity.id,
            temperature = entity.temperature,
            heartRate = entity.heartRate,
            date = entity.date,
            time = entity.time,
            device = entity.device,
            petId = entity.pet.id
        )
}

