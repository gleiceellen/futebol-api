package com.pucminas.apiwebservices.model.request

import com.pucminas.apiwebservices.model.Player

data class PlayerUpdateDto(
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
