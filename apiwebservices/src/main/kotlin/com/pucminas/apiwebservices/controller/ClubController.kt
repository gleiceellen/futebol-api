package com.pucminas.apiwebservices.controller


import com.pucminas.apiwebservices.model.Club
import com.pucminas.apiwebservices.model.request.ClubRequest
import com.pucminas.apiwebservices.model.request.ClubUpdateRequest
import com.pucminas.apiwebservices.service.ClubService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ClubController(
    private val clubService: ClubService
) {

    @PostMapping("/club")
    fun createClub(@RequestBody club: ClubRequest): ResponseEntity<Club> {
        return ResponseEntity.ok(clubService.createClub(club))
    }

    @GetMapping("/club")
    fun getClub(): ResponseEntity<*> {
        return ResponseEntity.ok(clubService.getClubs())
    }

    @PutMapping("/club/{id}")
    fun updateClub(
            @PathVariable(value = "id") clubId: Long,
            @RequestBody club: ClubUpdateRequest
    ): ResponseEntity<Club> {
        return ResponseEntity.ok(clubService.updateClub(club, clubId))
    }

    @DeleteMapping("/club/{id}")
    fun deleteClub(@PathVariable(value = "id") clubId: Long): ResponseEntity<*> {
        return ResponseEntity.ok(clubService.deleteClub(clubId))
    }
}