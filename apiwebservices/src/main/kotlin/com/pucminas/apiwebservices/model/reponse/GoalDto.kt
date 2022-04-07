package com.pucminas.apiwebservices.model.reponse

import com.pucminas.apiwebservices.model.Goal

data class GoalResponseDto(
    val club: ClubPartialResponseDto,
    val player: PlayerPartialResponseDto,
    val game: GameResponseDto,
    val date: String
)


data class GoalPartialResponseDto(
        val club: ClubPartialResponseDto,
        val player: PlayerPartialResponseDto,
        val date: String
)
{
    companion object {
        fun fromGoal(goal: Goal): GoalPartialResponseDto {
            return GoalPartialResponseDto(
                    club = ClubPartialResponseDto.fromClub(goal.club),
                    player = PlayerPartialResponseDto.fromPlayer(goal.player ),
                    date = goal.date
            )
        }
    }
}