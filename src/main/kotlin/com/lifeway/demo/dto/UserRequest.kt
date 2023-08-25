package com.lifeway.demo.dto

data class UserRequest(
    val firstName: String,
    val lastName: String,
    val username: String? = null,
    val email: String? = null,
    val mobileNumber: String,
)