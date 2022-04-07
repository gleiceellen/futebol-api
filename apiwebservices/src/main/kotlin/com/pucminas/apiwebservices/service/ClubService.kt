package com.pucminas.apiwebservices.service


import com.pucminas.apiwebservices.model.Club
import com.pucminas.apiwebservices.model.request.ClubInsertDto
import com.pucminas.apiwebservices.model.request.ClubUpdateDto
import com.pucminas.apiwebservices.model.request.toClub
import com.pucminas.apiwebservices.repository.ClubRepository
import com.pucminas.apiwebservices.exception.ClubUpdateException
import org.springframework.stereotype.Service
import java.util.*

@Service
class ClubService(
    private val clubRepository: ClubRepository
){
    fun getClubs(): List<Club> {
        return clubRepository.findAll()
    }

    fun createClub(clubInsert: ClubInsertDto): Club {
        return clubRepository.save(clubInsert.toClub())
    }

    fun updateClub(club: ClubUpdateDto, clubId: Long): Club? {
        val search = clubRepository.findById(clubId)

        return if(search.isPresent) {
            handleUpdateExistentClub(search, club)
        }
        else {
            handleUpdateNotExistentClub(club)
        }
    }

    private fun handleUpdateNotExistentClub(club: ClubUpdateDto) =
        if (club.name != null && club.location != null) {
            val clubToInsert = Club(
                    name = club.name,
                    location = club.location)

            clubRepository.save(clubToInsert)
        } else
            throw ClubUpdateException(ClubUpdateException.CANT_UPDATE_OR_INSERT)

    private fun handleUpdateExistentClub(search: Optional<Club>, club: ClubUpdateDto): Club {
        val clubStored = search.get()

        val clubUpdated = Club(
                id = clubStored.id,
                name = club.name ?: clubStored.name,
                location = club.location ?: clubStored.location
        )
        return clubRepository.save(clubUpdated)
    }

    fun deleteClub(clubId: Long): String {
        val entity = clubRepository.findById(clubId)

        return if(entity.isPresent) {
            val club = entity.get()
            clubRepository.delete(club)
            "entity removed"
        }
        else {
            "entity does not exists"
        }
    }
}