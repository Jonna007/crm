package com.example.crm.repository

import com.example.crm.entity.VitalSign
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface VitalSignRepository : JpaRepository<VitalSign, Long> {
    @Query("SELECT v FROM VitalSign v WHERE v.pet.id = :petId ORDER BY v.date DESC, v.time DESC")
    fun findAllByPetIdOrderByDateTimeDesc(petId: Long): List<VitalSign>
}

