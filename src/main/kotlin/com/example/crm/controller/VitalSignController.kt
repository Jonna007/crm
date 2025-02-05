package com.example.crm.controller

import com.example.crm.dto.CreateVitalSignDTO
import com.example.crm.dto.VitalSignDTO
import com.example.crm.service.VitalSignService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/vital-signs")
class VitalSignController(private val vitalSignService: VitalSignService) {

    @PostMapping
    fun createVitalSign(@RequestBody createVitalSignDTO: CreateVitalSignDTO): ResponseEntity<VitalSignDTO> {
        val vitalSignDTO = vitalSignService.createVitalSign(createVitalSignDTO)
        return ResponseEntity(vitalSignDTO, HttpStatus.CREATED)
    }

    @GetMapping("/pet/{petId}")
    fun getVitalSignsByPetId(@PathVariable petId: Long): ResponseEntity<List<VitalSignDTO>> {
        val vitalSigns = vitalSignService.getVitalSignsByPetId(petId)
        return ResponseEntity.ok(vitalSigns)
    }
}

