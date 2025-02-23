package com.example.warningtracker.exampleWarnings

import com.example.warningtracker.exceptions.NotFoundException
import com.example.warningtracker.rename.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleController {

    @GetMapping("/example/{id}")
    fun getExample(@PathVariable id: Long): String {
        if (id == 1L) {
            throw NotFoundException("Resource not found")
        }
        return "Example"
    }

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(message = ex.message ?: "Not Found", status = HttpStatus.NOT_FOUND.value())
        return ResponseEntity(errorResponse, HttpStatus.NOT_FOUND)
    }
}