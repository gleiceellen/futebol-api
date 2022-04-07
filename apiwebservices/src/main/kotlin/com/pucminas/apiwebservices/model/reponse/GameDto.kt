package com.pucminas.apiwebservices.model.reponse


import com.pucminas.apiwebservices.model.Game

data class GameResponseDto(
        val id: Long,
        val ownerClub: ClubPartialResponseDto,
        val guestClub: ClubPartialResponseDto,
        val date: String,
        val startTime: String? = null,
        val endTime: String? = null,

        val goals: List<GoalPartialResponseDto> = emptyList(),
        val intervals: List<IntervalResponseDto> = emptyList(),
        val increments: List<IncrementResponseDto> = emptyList(),
        val warnings: List<WarningResponseDto> = emptyList()
) {
    companion object {
        fun fromGame(game: Game): GameResponseDto {
            return GameResponseDto(
                id = game.id!!,
                ownerClub = ClubPartialResponseDto.fromClub(game.ownerClub),
                guestClub = ClubPartialResponseDto.fromClub(game.guestClub),
                date = game.date,
                startTime = game.startTime,
                endTime = game.endTime,
                goals = game.goals.map { GoalPartialResponseDto.fromGoal(it) },
                intervals = game.intervalls.map { IntervalResponseDto.fromInterval(it) },
                increments = game.increments.map { IncrementResponseDto.fromIncrement(it) },
                warnings = game.warnings.map { WarningResponseDto.fromWarning(it) }
            )
        }
    }
}