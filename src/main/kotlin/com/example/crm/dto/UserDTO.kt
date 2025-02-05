package com.example.crm.dto

import java.time.LocalDateTime

data class UserDTO(
    val id: Long?,
    val name: String,
    val email: String,
    val registrationDate: LocalDateTime?
)

data class CreateUserDTO(
    val name: String,
    val email: String,
    val password: String
)

