package com.lifeway.demo.model

import com.lifeway.demo.dto.UserRequest
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

@Table(name = "users")
@Entity
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @field: NotBlank(message = "First name is required")
    @Column(name = "first_name")
    var firstName: String,

    @field: NotBlank(message = "Last name is required")
    @Column(name = "last_name")
    var lastName: String,

    @Column(unique = true, updatable = false)
    @field:Pattern(regexp = "^[A-Za-z0-9]+$", message = "Username can only contain letters and numbers.")
    @field:NotBlank(message = "Username is required")
    var username: String?,

    @Column(unique = true, updatable = false)
    @field:Email(message = "Invalid email format")
    @field: NotBlank(message = "Email is required")
    var email: String?,

    @field:Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits")
    @field: NotBlank(message = "Mobile number is required")
    @Column(name = "mobile_number")
    var mobileNumber: String
)  {

    constructor(userRequest: UserRequest): this(
        firstName = userRequest.firstName,
        lastName = userRequest.lastName,
        email = userRequest.email,
        username = userRequest.username,
        mobileNumber = userRequest.mobileNumber
    )
}