package com.pucminas.apiwebservices.controller

import com.pucminas.apiwebservices.model.reponse.ClubResponseDto
import com.pucminas.apiwebservices.model.reponse.TransferResponseDto
import com.pucminas.apiwebservices.model.request.ClubInsertDto
import com.pucminas.apiwebservices.model.request.TransferInsertDto
import com.pucminas.apiwebservices.service.TransferService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TransferController(
    private val transferService: TransferService
) {
    @PostMapping("/transfer")
    fun createClub(
        @RequestBody transferInsertDto: TransferInsertDto
    ): ResponseEntity<TransferResponseDto> {
        val transfer = transferService.createTransfer(transferInsertDto)
        return ResponseEntity.ok(TransferResponseDto.fromTransfer(transfer))
    }
}