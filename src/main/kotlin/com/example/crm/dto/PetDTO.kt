package com.example.crm.dto

data class PetDTO(
    val id: Long?,
    val name: String,
    val species: String,
    val breed: String?,
    val age: Int?,
    val ownerdName: String?,
    val userId: Long
)

data class CreatePetDTO(
    val name: String,
    val species: String,
    val breed: String?,
    val age: Int?,
    val ownerdName: String?,
    val userId: Long
)

