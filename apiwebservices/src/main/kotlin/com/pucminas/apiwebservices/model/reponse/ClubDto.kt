package com.pucminas.apiwebservices.model.reponse


import com.pucminas.apiwebservices.model.Club

data class ClubResponseDto(
        val name: String,
        val location: String,
        val titles: List<String>? = null,
        val players: MutableList<PlayerPartialResponseDto> = mutableListOf()
)
{
    companion object {
        fun fromClub(club: Club) = ClubResponseDto(
            name = club.name,
            location = club.location,
            players = club.players.map {
                PlayerPartialResponseDto(
                        name = it.name,
                        birthDate = it.birthDate,
                        country = it.country
                )
            }.toMutableList()
        )
    }
}

data class ClubPartialResponseDto(
    val name: String,
    val location: String,
    val titles: List<String>? = null
)
{

    companion object {
        fun fromClub(club: Club) = ClubPartialResponseDto(
            name = club.name,
            location = club.location
        )
    }
}

