package com.pucminas.apiwebservices.model.reponse


import com.pucminas.apiwebservices.model.Club
import com.pucminas.apiwebservices.model.Contest
import com.pucminas.apiwebservices.model.Game

data class ContestResponseDto(
    val id: Long,
    val name: String,
    val startDate: String,
    val finishDate: String,
    val games: List<GameResponseDto>? = listOf()
) {
    companion object {
        fun fromContest(contest: Contest) = ContestResponseDto(
                id = contest.id!!,
                name = contest.name,
                startDate = contest.startDate,
                finishDate = contest.finishDate,
                games = contest.games.map { GameResponseDto.fromGame(it) }
        )
    }
}


