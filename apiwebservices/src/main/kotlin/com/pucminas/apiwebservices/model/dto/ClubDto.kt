package com.pucminas.apiwebservices.model.dto

import java.io.Serializable

data class ClubDto(
    val name: String? = null,
    val location: String? = null,
    val titles: String? = null
) : Serializable
