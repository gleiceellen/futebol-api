package com.pucminas.apiwebservices.controller


import com.pucminas.apiwebservices.model.Club
import com.pucminas.apiwebservices.model.request.ClubInsertDto
import com.pucminas.apiwebservices.model.request.ClubUpdateDto
import com.pucminas.apiwebservices.service.ClubService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ClubController(
    private val clubService: ClubService
) {

    @PostMapping("/club")
    fun createClub(@RequestBody club: ClubInsertDto): ResponseEntity<Club> {
        return ResponseEntity.ok(clubService.createClub(club))
    }

    @GetMapping("/club")
    fun getClub(): ResponseEntity<*> {
        return ResponseEntity.ok(clubService.getClubs())
    }

    @GetMapping("/club/{id}")
    fun getClub(@PathVariable(value = "id") clubId: Long): ResponseEntity<*> {
        val club = clubService.getClub(clubId)

        return if(club == null)
            ResponseEntity<Any>(HttpStatus.NOT_FOUND)
        else
            ResponseEntity.ok(club)
    }

    @PutMapping("/club/{id}")
    fun updateClub(
            @PathVariable(value = "id") clubId: Long,
            @RequestBody club: ClubUpdateDto
    ): ResponseEntity<Club> {
        return ResponseEntity.ok(clubService.updateClub(club, clubId))
    }

    @DeleteMapping("/club/{id}")
    fun deleteClub(@PathVariable(value = "id") clubId: Long): ResponseEntity<*> {
        return ResponseEntity.ok(clubService.deleteClub(clubId))
    }

    @DeleteMapping("/club/{club-id}/players/{player-id}")
    fun deletePlayer(
            @PathVariable(value = "club-id") clubId: Long,
            @PathVariable(value = "player-id") playerId: Long
    ): ResponseEntity<*> {
        return ResponseEntity.ok(clubService.deletePlayer(clubId, playerId))
    }
}