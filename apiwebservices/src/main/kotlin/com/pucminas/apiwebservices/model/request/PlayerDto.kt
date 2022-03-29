package com.pucminas.apiwebservices.model.request

import java.io.Serializable

data class PlayerDto(
    val name: String? = null,
    val birthDate: String? = null,
    val country: String? = null,
    val club: ClubRequest? = null
) : Serializable
