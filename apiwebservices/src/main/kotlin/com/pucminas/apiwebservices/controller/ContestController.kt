package com.pucminas.apiwebservices.controller

import com.pucminas.apiwebservices.model.reponse.ContestResponseDto
import com.pucminas.apiwebservices.model.reponse.TransferResponseDto
import com.pucminas.apiwebservices.model.request.ContestInsertDto
import com.pucminas.apiwebservices.model.request.GameInsertDto
import com.pucminas.apiwebservices.model.request.GoalInsertDto
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
    fun createContest(
        @RequestBody contestInsertDto: ContestInsertDto
    ): ResponseEntity<*> {
        val contest = contestService.createContest(contestInsertDto)
        return ResponseEntity.ok(ContestResponseDto.fromContest(contest))
    }

    @GetMapping("/contests")
    fun getContests(): ResponseEntity<*> {
        val contests = contestService.getContests()
        val contestResponse = contests.map { ContestResponseDto.fromContest(it) }
        return ResponseEntity.ok(contestResponse)
    }

    @PostMapping("/contests/{id}/games")
    fun createGame(
            @PathVariable(value = "id") contestId: Long,
            @RequestBody gameInsertDto: GameInsertDto
    ): ResponseEntity<*> {
        val game = contestService.createGame(contestId, gameInsertDto)
        return ResponseEntity.ok(ContestResponseDto.fromContest(game.contest!!))
    }

    @PostMapping("/contests/{contest-id}/games/{game-id}/events/start")
    fun startGame(
            @PathVariable(value = "contest-id") contestId: Long,
            @PathVariable(value = "game-id") gameId: Long,
    ): ResponseEntity<*> {
        val game = contestService.startGame(contestId, gameId)
        return ResponseEntity.ok(ContestResponseDto.fromContest(game.contest!!))
    }

    @PostMapping("/contests/{contest-id}/games/{game-id}/events/finish")
    fun finishGame(
            @PathVariable(value = "contest-id") contestId: Long,
            @PathVariable(value = "game-id") gameId: Long,
    ): ResponseEntity<*> {
        val game = contestService.finishGame(contestId, gameId)
        return ResponseEntity.ok(ContestResponseDto.fromContest(game.contest!!))
    }

    @PostMapping("/contests/{contest-id}/games/{game-id}/events/goal")
    fun finishGame(
            @PathVariable(value = "contest-id") contestId: Long,
            @PathVariable(value = "game-id") gameId: Long,
            @RequestBody goalInsertDto: GoalInsertDto
    ): ResponseEntity<*> {
        val game = contestService.registerGoal(contestId, gameId, goalInsertDto)
        return ResponseEntity.ok(ContestResponseDto.fromContest(game.contest!!))
    }
}