package com.pucminas.apiwebservices.controller

import com.pucminas.apiwebservices.model.reponse.ContestResponseDto
import com.pucminas.apiwebservices.model.reponse.TransferResponseDto
import com.pucminas.apiwebservices.model.request.ContestInsertDto
import com.pucminas.apiwebservices.model.request.TransferInsertDto
import com.pucminas.apiwebservices.service.ContestService
import com.pucminas.apiwebservices.service.TransferService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ContestController(
    private val contestService: ContestService
) {
    @PostMapping("/contests")
    fun createClub(
        @RequestBody contestInsertDto: ContestInsertDto
    ): ResponseEntity<*> {
        val contest = contestService.createContest(contestInsertDto)
        return ResponseEntity.ok(ContestResponseDto.fromContest(contest))
    }

    @GetMapping("/contests")
    fun createClub(): ResponseEntity<*> {
        val contests = contestService.getContests()
        val contestResponse = contests.map { ContestResponseDto.fromContest(it) }
        return ResponseEntity.ok(contestResponse)
    }
}