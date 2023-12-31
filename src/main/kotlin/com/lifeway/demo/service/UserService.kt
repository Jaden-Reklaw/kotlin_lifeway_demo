package com.lifeway.demo.service

import com.lifeway.demo.dto.UserRequest
import com.lifeway.demo.model.User
import com.lifeway.demo.repository.UserRepository
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*



@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun getUserById(id: Long): Optional<User> {
        return userRepository.findById(id)
    }

    @Transactional
    fun createNewUser(userRequest: UserRequest): User {

        val newUser = User(
            firstName = userRequest.firstName,
            lastName = userRequest.lastName,
            email = userRequest.email,
            username = userRequest.username,
            mobileNumber = userRequest.mobileNumber
        )

        return userRepository.save(newUser)
    }

    @Transactional
    fun updateUserById(id: Long, userRequest: UserRequest) {
        val existingUser = userRepository.findById(id)
            .orElseThrow{ EntityNotFoundException("User not Found") }

        existingUser.firstName = userRequest.firstName
        existingUser.lastName = userRequest.lastName
        existingUser.mobileNumber = userRequest.mobileNumber

        userRepository.save(existingUser)
    }

    @Transactional
    fun deleteUserById(id: Long) {
        val existingUser = userRepository.findById(id)
            .orElseThrow{EntityNotFoundException("User not Found")}

        userRepository.delete(existingUser)
    }


}