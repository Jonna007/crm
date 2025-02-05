package com.example.crm.service

import com.example.crm.dto.CreateUserDTO
import com.example.crm.dto.UserDTO
import com.example.crm.mapper.UserMapper
import com.example.crm.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) {
    @Transactional
    fun createUser(createUserDTO: CreateUserDTO): UserDTO {
        val user = userMapper.toEntity(createUserDTO)
        val savedUser = userRepository.save(user)
        return userMapper.toDTO(savedUser)
    }

    @Transactional(readOnly = true)
    fun getUserWithPets(id: Long): UserDTO {
        val user = userRepository.findByIdWithPets(id)
            .orElseThrow { NoSuchElementException("User not found with id: $id") }
        return userMapper.toDTO(user)
    }
}

