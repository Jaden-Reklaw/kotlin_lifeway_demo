package com.lifeway.demo.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

data class HealthCheckObject(var timestamp: LocalDateTime, var message:String) {
    constructor():this(LocalDateTime.now(), "Server Ok!")
}

@RestController
@RequestMapping("/health")
class HealthCheckController {

    @GetMapping
    fun getHealthCheck(): ResponseEntity<HealthCheckObject> {
        return ResponseEntity(HealthCheckObject(), HttpStatus.OK);
    }
}