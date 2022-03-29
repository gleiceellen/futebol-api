package com.pucminas.apiwebservices.model.dto

import com.pucminas.apiwebservices.model.dto.ClubDto
import java.io.Serializable

data class PlayerDto(
    val name: String? = null,
    val birthDate: String? = null,
    val country: String? = null,
    val club: ClubDto? = null
) : Serializable
