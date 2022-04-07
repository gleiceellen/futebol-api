package com.pucminas.apiwebservices.model.request

import com.pucminas.apiwebservices.model.Warning

data class WarningInsertDto(
    val playerId: Long,
    val time: String,
    val type: String
)

