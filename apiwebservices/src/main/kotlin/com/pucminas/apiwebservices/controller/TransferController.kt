package com.pucminas.apiwebservices.controller

import com.pucminas.apiwebservices.model.reponse.TransferResponseDto
import com.pucminas.apiwebservices.model.request.TransferInsertDto
import com.pucminas.apiwebservices.service.TransferService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class TransferController(
    private val transferService: TransferService
) {
    @PostMapping("/transfers")
    fun createClub(
        @RequestBody transferInsertDto: TransferInsertDto
    ): ResponseEntity<TransferResponseDto> {
        val transfer = transferService.createTransfer(transferInsertDto)
        return ResponseEntity.ok(TransferResponseDto.fromTransfer(transfer))
    }

    @GetMapping("/transfers")
    fun getClub(): ResponseEntity<*> {
        val transfers = transferService.getTransfers().map { TransferResponseDto.fromTransfer(it) }
        return ResponseEntity.ok(transfers )
    }

    @GetMapping("/transfers/{id}")
    fun getClub(
            @PathVariable(value = "id") transferId: Long
    ): ResponseEntity<*> {
        val transfer = transferService.getTransfer(transferId)
        return if(transfer == null)
            ResponseEntity<Any>(HttpStatus.NOT_FOUND)
        else
            ResponseEntity.ok(TransferResponseDto.fromTransfer(transfer))
    }

}