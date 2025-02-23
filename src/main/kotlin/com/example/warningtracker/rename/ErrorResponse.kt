package com.example.warningtracker.rename

import java.time.LocalDateTime

data class ErrorResponse(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val message: String,
    val status: Int,
)
