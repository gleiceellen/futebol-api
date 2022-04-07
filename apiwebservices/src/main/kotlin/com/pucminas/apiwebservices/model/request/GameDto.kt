package com.pucminas.apiwebservices.model.request

import com.pucminas.apiwebservices.model.Game


data class GameInsertDto(
    val ownerClubId: Long,
    val guestClubId: Long,
    val date: String
)