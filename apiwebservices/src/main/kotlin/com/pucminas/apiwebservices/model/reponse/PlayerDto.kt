package com.pucminas.apiwebservices.model.reponse

import com.pucminas.apiwebservices.model.Player

data class PlayerResponseDto(
        val name: String? = null,
        val birthDate: String? = null,
        val country: String? = null,
        val club: ClubPartialResponseDto? = null
)
{
    companion object {
        fun fromPlayer(player: Player): PlayerResponseDto {
            val club  = if(player.club != null)
                ClubPartialResponseDto.fromClub(player.club!!)
            else
                null

            return PlayerResponseDto(
                name = player.name,
                country = player.country,
                birthDate = player.birthDate,
                club = club
            )
        }
    }
}

data class PlayerPartialResponseDto(
    val name: String? = null,
    val birthDate: String? = null,
    val country: String? = null
)
