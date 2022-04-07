package com.pucminas.apiwebservices.model.request


import com.pucminas.apiwebservices.model.Club

data class ClubInsertDto(
    val name: String,
    val location: String,
    val titles: List<String>? = null,
    val players: List<PlayerInsertDto> = emptyList()
)

data class ClubUpdateDto(
    val id: Long,
    val name: String? = null,
    val location: String? = null,
    val titles: List<String>? = null
)

fun ClubInsertDto.toClub() = Club(
    name = this.name,
    location = this.location,
    players = this.players.map { playerInsertDto -> playerInsertDto.toPlayer() }
)
