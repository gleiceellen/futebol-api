package com.pucminas.apiwebservices.model.reponse


import com.pucminas.apiwebservices.model.Club
import com.pucminas.apiwebservices.model.Contest

data class ContestResponseDto(
    val id: Long,
    val name: String,
    val startDate: String,
    val finishDate: String
) {
    companion object {
        fun fromContest(contest: Contest) = ContestResponseDto(
                id = contest.id!!,
                name = contest.name,
                startDate = contest.startDate,
                finishDate = contest.finishDate
        )
    }
}


