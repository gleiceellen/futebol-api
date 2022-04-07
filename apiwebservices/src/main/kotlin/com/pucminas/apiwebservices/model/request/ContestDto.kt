package com.pucminas.apiwebservices.model.request


import com.pucminas.apiwebservices.model.Contest

data class ContestInsertDto(
    val name: String,
    val startDate: String,
    val finishDate: String
)

fun ContestInsertDto.toContest() = Contest(
    name = this.name,
    startDate = this.startDate,
    finishDate = this.finishDate
)
