package com.example.warningtracker.service


import com.example.warningtracker.exceptions.AlreadyExistsException
import com.example.warningtracker.exceptions.NotFoundException
import com.example.warningtracker.rename.ErrorResponse
import org.springframework.http.ResponseEntity

interface EXService {
    fun catchError(exception: Exception) : ResponseEntity<ErrorResponse>
    fun handleNotFoundException(exception: NotFoundException) : ResponseEntity<ErrorResponse>
    fun handleAlreadyExsistsException(exception: AlreadyExistsException) : ResponseEntity<ErrorResponse>
    fun handleEnoughException(exception: Exception) : ResponseEntity<ErrorResponse>
}