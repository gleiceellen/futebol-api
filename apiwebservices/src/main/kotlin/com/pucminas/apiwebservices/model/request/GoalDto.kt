package com.pucminas.apiwebservices.model.request

import com.pucminas.apiwebservices.model.Goal

data class GoalInsertDto(
    val clubId: Long,
    val playerId: Long,
    val date: String
)