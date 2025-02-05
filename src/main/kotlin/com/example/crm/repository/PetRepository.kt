package com.example.crm.repository

import com.example.crm.entity.Pet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface PetRepository : JpaRepository<Pet, Long> {
    @Query("""
        SELECT p FROM Pet p 
        LEFT JOIN FETCH p.vitalSigns 
        WHERE p.user.id = :userId
    """)
    fun findAllByUserId(userId: Long): List<Pet>
}

