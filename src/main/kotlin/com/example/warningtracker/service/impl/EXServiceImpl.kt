package com.example.warningtracker.service.impl


import com.example.warningtracker.exceptions.AlreadyExistsException
import com.example.warningtracker.exceptions.NotFoundException
import com.example.warningtracker.rename.ErrorResponse
import com.example.warningtracker.service.EXService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class EXServiceImpl : EXService {
    override fun catchError(exception: Exception): ResponseEntity<ErrorResponse> {
        TODO("Not yet implemented")
    }
    @ExceptionHandler(NotFoundException::class)
    override fun handleNotFoundException(exception: NotFoundException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            message = exception.message ?: "Not found",
            status = HttpStatus.NOT_FOUND.value(),
        )
        return ResponseEntity(errorResponse, HttpStatus.NOT_FOUND)
    }
    @ExceptionHandler(AlreadyExistsException::class)
    override fun handleAlreadyExsistsException(exception: AlreadyExistsException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            message = exception.message ?: "Already Exists",
            status = HttpStatus.BAD_REQUEST.value(),
        )
        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Exception::class)
    override fun handleEnoughException(exception: Exception): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            message = exception.message ?: "Aaaaaaaaaaaaa",
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
        )
        return ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}