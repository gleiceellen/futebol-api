package com.pucminas.apiwebservices.model.request

import com.pucminas.apiwebservices.model.Player

data class PlayerUpdateDto(
    val id: Long? = null,
    val name: String? = null,
    val birthDate: String? = null,
    val country: String? = null
)

data class PlayerInsertDto(
    val name: String,
    val birthDate: String,
    val country: String
)

fun PlayerInsertDto.toPlayer() = Player(
    name = this.name,
    birthDate = this.birthDate,
    country = this.country
)

fun PlayerUpdateDto.toPlayer(player: Player) = Player(
    id = player.id,
    name = this.name ?: player.name,
    birthDate = this.birthDate ?: player.birthDate,
    country = this.country ?: player.country,
    club = player.club
)


