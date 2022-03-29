package com.pucminas.apiwebservices.controller

import Club
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
    fun createClub(club: ClubRequest): ResponseEntity<Club> {
        return ResponseEntity.ok(clubService.createClub(club))
    }

    @GetMapping("/club")
    fun getClub(): ResponseEntity<*> {
        return ResponseEntity.ok(clubService.getClubs())
    }

    @PutMapping("/club")
    fun updateClub(club: ClubUpdateRequest): ResponseEntity<Club> {
        return ResponseEntity.ok(clubService.updateClub(club))
    }

    @DeleteMapping("/club")
    fun deleteClub(club: ClubRequest): ResponseEntity<*> {
        return ResponseEntity.ok(clubService.deleteClub(club))
    }
}