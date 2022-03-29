package com.pucminas.apiwebservices.model.request

import Club
import java.io.Serializable

data class ClubRequest(
    val name: String,
    val location: String,
    val titles: List<String>? = null
) : Serializable

data class ClubUpdateRequest(
    val id: Long,
    val name: String? = null,
    val location: String? = null,
    val titles: List<String>? = null
) : Serializable

fun ClubRequest.clubRequestToClub() = Club(
    name = this.name,
    location = this.location,
    titles = this.titles
)
