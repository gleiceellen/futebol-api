package com.pucminas.apiwebservices.model.request

import org.apache.juli.logging.Log

data class TransferInsertDto(
    val originClubId: Long,
    val destinationClubId: Long,
    val playerId: Long,
    val date: String,
    val amount: String,

)


