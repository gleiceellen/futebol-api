package com.pucminas.apiwebservices.model.reponse


import com.pucminas.apiwebservices.model.Club

data class ClubResponseDto(
        val id: Long,
        val name: String,
        val location: String,
        val titles: List<String>? = null,
        val players: MutableList<PlayerPartialResponseDto> = mutableListOf()
)
{
    companion object {
        fun fromClub(club: Club) = ClubResponseDto(
            id = club.id!!,
            name = club.name,
            location = club.location,
            players = club.players.map {
                PlayerPartialResponseDto.fromPlayer(it)
            }.toMutableList()
        )
    }
}

data class ClubPartialResponseDto(
    val id: Long,
    val name: String,
    val location: String,
    val titles: List<String>? = null
)
{
    companion object {
        fun fromClub(club: Club) = ClubPartialResponseDto(
            id = club.id!!,
            name = club.name,
            location = club.location
        )
    }
}

