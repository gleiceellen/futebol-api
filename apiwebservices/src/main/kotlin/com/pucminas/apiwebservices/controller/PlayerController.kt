package com.pucminas.apiwebservices.controller

import com.pucminas.apiwebservices.model.reponse.ClubResponseDto
import com.pucminas.apiwebservices.model.reponse.PlayerResponseDto
import com.pucminas.apiwebservices.model.request.ClubUpdateDto
import com.pucminas.apiwebservices.model.request.PlayerUpdateDto
import com.pucminas.apiwebservices.service.PlayerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class PlayerController(
    private val playerService: PlayerService
){
    @GetMapping("/players")
    fun getClub(): ResponseEntity<*> {
        val players = playerService.getPLayers().map { PlayerResponseDto.fromPlayer(it) }
        return ResponseEntity.ok(players )
    }

    @GetMapping("/players/{id}")
    fun getClub(@PathVariable(value = "id") playerId: Long): ResponseEntity<*> {
        val player = playerService.getPlayer(playerId)

        return if(player == null)
            ResponseEntity<Any>(HttpStatus.NOT_FOUND)
        else
            ResponseEntity.ok(PlayerResponseDto.fromPlayer(player))
    }

    @PutMapping("/players/{id}")
    fun updateClub(
            @PathVariable(value = "id") playerId: Long,
            @RequestBody playerUpdateDto: PlayerUpdateDto
    ): ResponseEntity<*> {
        return ResponseEntity.ok(PlayerResponseDto.fromPlayer(playerService.updatePlayer(playerId, playerUpdateDto)))
    }
}