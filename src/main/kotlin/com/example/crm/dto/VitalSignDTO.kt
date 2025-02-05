package com.example.crm.dto

import java.time.LocalDate
import java.time.LocalTime

data class VitalSignDTO(
    val id: Long?,
    val temperature: Double?,
    val heartRate: Int?,
    val date: LocalDate,
    val time: LocalTime,
    val device: String?,
    val petId: Long
)

data class CreateVitalSignDTO(
    val temperature: Double?,
    val heartRate: Int?,
    val date: LocalDate,
    val time: LocalTime,
    val device: String?,
    val petId: Long
)

