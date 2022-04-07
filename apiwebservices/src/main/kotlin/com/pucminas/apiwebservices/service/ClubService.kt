package com.pucminas.apiwebservices.service


import com.pucminas.apiwebservices.model.Club
import com.pucminas.apiwebservices.model.request.ClubRequest
import com.pucminas.apiwebservices.model.request.ClubUpdateRequest
import com.pucminas.apiwebservices.model.request.clubRequestToClub
import com.pucminas.apiwebservices.repository.ClubRepository
import org.springframework.stereotype.Service

@Service
class ClubService(
    private val clubRepository: ClubRepository
){
    fun getClubs(): List<Club> {
        return clubRepository.findAll()
    }

    fun createClub(club: ClubRequest): Club {
        return clubRepository.save(club.clubRequestToClub())
    }

    fun updateClub(club: ClubUpdateRequest): Club? {
        val clubFound = clubRepository.getById(club.id)
        val clubToUpdate = Club(
            id = clubFound.id,
            name = club.name ?: clubFound.name,
            location = club.location ?: clubFound.location
        )
        return clubToUpdate
    }

    fun deleteClub(club: ClubRequest): String {
        clubRepository.delete(club.clubRequestToClub())
        return "Resource deteled with success"
    }
}