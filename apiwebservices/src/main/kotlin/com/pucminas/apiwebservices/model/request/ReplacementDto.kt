package com.pucminas.apiwebservices.model.request

import com.pucminas.apiwebservices.model.Goal

data class ReplacementInsertDto(
    val clubId: Long,
    val playerInId: Long,
    val playerOutId: Long,
    val date: String
)