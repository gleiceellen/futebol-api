package com.pucminas.apiwebservices.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime


@ControllerAdvice
class ExceptionHandler {


    @ExceptionHandler(ClubUpdateException::class)
    fun  handleClubUpdateErrors(
        exception: ClubUpdateException
    ): ResponseEntity<Map<String,String>> {

        val body: MutableMap<String, String> = HashMap()
        body["timestamp"] = LocalDateTime.now().toString()
        body["message"] = exception.message.toString()

        return ResponseEntity<Map<String,String>>(body, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(TransferCreateException::class)
    fun  handleTransferCreationErrors(
            exception: TransferCreateException
    ): ResponseEntity<Map<String,String>> {

        val body: MutableMap<String, String> = HashMap()
        body["timestamp"] = LocalDateTime.now().toString()
        body["message"] = exception.message.toString()

        return ResponseEntity<Map<String,String>>(body, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(GameEventException::class)
    fun  handleGameEventErrors(
            exception: GameEventException
    ): ResponseEntity<Map<String,String>> {

        val body: MutableMap<String, String> = HashMap()
        body["timestamp"] = LocalDateTime.now().toString()
        body["message"] = exception.message.toString()

        return ResponseEntity<Map<String,String>>(body, HttpStatus.BAD_REQUEST)
    }
}