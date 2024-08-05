package com.example.demo

import kotlinx.coroutines.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class WarmupController() {

    private val random = Random

    @GetMapping("/warmup")
    suspend fun warmup(): ResponseEntity<Unit> {
        delay(random.nextLong(100, 201))
        return ResponseEntity.ok().build()
    }
}
