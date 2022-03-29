package com.pucminas.apiwebservices.model.request

import java.io.Serializable

data class TransferDto(
    val originClub: String? = null,
    val destinationClub: String? = null,
    val date: String? = null,
    val amount: String? = null
) : Serializable
