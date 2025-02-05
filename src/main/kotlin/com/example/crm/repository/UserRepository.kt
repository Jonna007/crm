package com.example.crm.repository

import com.example.crm.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional

interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): Optional<User>

    @Query("""
        SELECT u FROM User u 
        LEFT JOIN FETCH u.pets 
        WHERE u.id = :id
    """)
    fun findByIdWithPets(id: Long): Optional<User>
}

