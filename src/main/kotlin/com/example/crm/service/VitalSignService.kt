package com.example.crm.service

import com.example.crm.dto.CreateVitalSignDTO
import com.example.crm.dto.VitalSignDTO
import com.example.crm.mapper.VitalSignMapper
import com.example.crm.repository.VitalSignRepository
import com.example.crm.repository.PetRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class VitalSignService(
    private val vitalSignRepository: VitalSignRepository,
    private val petRepository: PetRepository,
    private val vitalSignMapper: VitalSignMapper
) {
    @Transactional
    fun createVitalSign(createVitalSignDTO: CreateVitalSignDTO): VitalSignDTO {
        val pet = petRepository.findById(createVitalSignDTO.petId)
            .orElseThrow { NoSuchElementException("Pet not found with id: ${createVitalSignDTO.petId}") }

        val vitalSign = vitalSignMapper.toEntity(createVitalSignDTO, pet)
        val savedVitalSign = vitalSignRepository.save(vitalSign)
        return vitalSignMapper.toDTO(savedVitalSign)
    }

    @Transactional(readOnly = true)
    fun getVitalSignsByPetId(petId: Long): List<VitalSignDTO> {
        return vitalSignRepository.findAllByPetIdOrderByDateTimeDesc(petId)
            .map { vitalSignMapper.toDTO(it) }
    }
}

