package com.ligon.deeznuts.services

import com.ligon.deeznuts.exceptions.ConflictException
import com.ligon.deeznuts.exceptions.NotFoundException
import com.ligon.deeznuts.exceptions.UnauthorizedException
import com.ligon.deeznuts.models.User
import com.ligon.deeznuts.models.requests.SignInRequest
import com.ligon.deeznuts.models.requests.SignUpRequest
import com.ligon.deeznuts.models.responses.AuthResponse
import com.ligon.deeznuts.repositories.UserRepository
import org.mindrot.jbcrypt.BCrypt

class AuthService(
    private val userRepository: UserRepository,
    private val jwtService: JWTService
) {
    suspend fun signUp(req: SignUpRequest): AuthResponse {
        val exists = userRepository.existsByUsernameOrPhoneNumber(req.username, req.phoneNumber)
        if (exists)
            throw ConflictException("User already exists")

        val hash = BCrypt.hashpw(req.password, BCrypt.gensalt())

        val user = userRepository.create(
            User(
                username = req.username,
                password = hash,
                firstName = req.firstName,
                lastName = req.lastName,
                phoneNumber = req.phoneNumber
            )
        )

        return AuthResponse(jwtService.generateToken(user.id))
    }

    suspend fun signIn(req: SignInRequest): AuthResponse {
        val user = userRepository.findByUsernameOrPhoneNumber(req.usernameOrPhoneNumber) ?: throw NotFoundException()
        if (!BCrypt.checkpw(req.password, user.password))
            throw UnauthorizedException("Login failed")

        return AuthResponse(jwtService.generateToken(user.id))
    }
}
