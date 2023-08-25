package com.lifeway.demo.controller

import com.lifeway.demo.dto.UserRequest
import com.lifeway.demo.model.User
import com.lifeway.demo.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI
import java.util.Optional

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<User>> {
        return ResponseEntity.ok().body(userService.getAllUsers())
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long) : ResponseEntity<User> {

        val fetchedUser: Optional<User> = userService.getUserById(id)

        return fetchedUser.map {user ->
            ResponseEntity.ok(user)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    fun createNewUser(@RequestBody userRequest: UserRequest): ResponseEntity<User> {
        val createdUser: User = userService.createNewUser(userRequest)

        val location: URI = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdUser.id)
            .toUri()

        return ResponseEntity.created(location).body(createdUser)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody userRequest: UserRequest): ResponseEntity<String> {
        userService.updateUserById(id, userRequest)
        return ResponseEntity.ok("User updated successfully!")
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<String> {
        userService.deleteUserById(id)
        return ResponseEntity.ok("User deleted successfully!")
    }
}