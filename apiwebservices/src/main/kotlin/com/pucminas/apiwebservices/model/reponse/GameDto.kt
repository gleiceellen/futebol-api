package com.pucminas.apiwebservices.model.reponse


import com.pucminas.apiwebservices.model.Club
import com.pucminas.apiwebservices.model.Contest
import com.pucminas.apiwebservices.model.Game

data class GameResponseDto(
        val id: Long,
        val ownerClub: ClubPartialResponseDto,
        val guestClub: ClubPartialResponseDto,
        val date: String,
        val startTime: String? = null,
        val endTime: String? = null,
) {
    companion object {
        fun fromGame(game: Game): GameResponseDto {
            return GameResponseDto(
                    id = game.id!!,
                    ownerClub = ClubPartialResponseDto.fromClub(game.ownerClub),
                    guestClub = ClubPartialResponseDto.fromClub(game.guestClub),
                    date = game.date,
                    startTime = game.startTime,
                    endTime = game.endTime
            )
        }
    }
}