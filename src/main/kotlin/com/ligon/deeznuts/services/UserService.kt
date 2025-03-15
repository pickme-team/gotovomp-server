package com.ligon.deeznuts.services

import com.ligon.deeznuts.exceptions.NotFoundException
import com.ligon.deeznuts.repositories.UserRepository

class UserService(private val userRepository: UserRepository) {
    suspend fun findById(id: Long) = userRepository.findById(id) ?: throw NotFoundException()
}

