package com.pucminas.apiwebservices.controller

import com.pucminas.apiwebservices.service.PlayerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PlayerController(
    private val playerService: PlayerService
){
    @GetMapping("/players")
    fun getClub(): ResponseEntity<*> {
        return ResponseEntity.ok(playerService.getPLayers())
    }

    @GetMapping("/players/{id}")
    fun getClub(@PathVariable(value = "id") playerId: Long): ResponseEntity<*> {
        val player = playerService.getPlayer(playerId)

        return if(player == null)
            ResponseEntity<Any>(HttpStatus.NOT_FOUND)
        else
            ResponseEntity.ok(player)
    }
}