package com.example.crm.controller

import com.example.crm.dto.CreateUserDTO
import com.example.crm.dto.UserDTO
import com.example.crm.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @PostMapping
    fun createUser(@RequestBody createUserDTO: CreateUserDTO): ResponseEntity<UserDTO> {
        val userDTO = userService.createUser(createUserDTO)
        return ResponseEntity(userDTO, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): ResponseEntity<UserDTO> {
        val userDTO = userService.getUserWithPets(id)
        return ResponseEntity.ok(userDTO)
    }
}

