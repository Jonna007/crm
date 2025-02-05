package com.example.crm.mapper

import com.example.crm.dto.UserDTO
import com.example.crm.dto.CreateUserDTO
import com.example.crm.entity.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class UserMapper(private val passwordEncoder: PasswordEncoder) {
    fun toEntity(dto: CreateUserDTO): User =
        User(
            name = dto.name,
            email = dto.email,
            password = passwordEncoder.encode(dto.password)
        )

    fun toDTO(entity: User): UserDTO =
        UserDTO(
            id = entity.id,
            name = entity.name,
            email = entity.email,
            registrationDate = entity.registrationDate
        )
}

