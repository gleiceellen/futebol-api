package com.pucminas.apiwebservices.service

import com.pucminas.apiwebservices.exception.GameCreateException
import com.pucminas.apiwebservices.exception.GameEventException
import com.pucminas.apiwebservices.exception.PlayerUpdateException
import com.pucminas.apiwebservices.model.Contest
import com.pucminas.apiwebservices.model.Game
import com.pucminas.apiwebservices.model.Goal
import com.pucminas.apiwebservices.model.Player
import com.pucminas.apiwebservices.model.request.*
import com.pucminas.apiwebservices.repository.ContestRepository
import com.pucminas.apiwebservices.repository.GameRepository
import com.pucminas.apiwebservices.repository.GoalRepository
import com.pucminas.apiwebservices.repository.PlayerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class GoalService(
    private val goalRepository: GoalRepository,
    private val playerService: PlayerService,
    private val clubService: ClubService
) {

   fun createGoal(goalInsertDto: GoalInsertDto): Goal {
      val player = playerService.getPlayer(goalInsertDto.playerId)
              ?: throw GameEventException(GameCreateException.PLAYER_NOT_FOUND)

      val club = clubService.getClub(goalInsertDto.clubId)
              ?: throw GameEventException(GameCreateException.CLUB_NOT_FOUND)

      return Goal(
              player = player,
              club = club,
              date = goalInsertDto.date
      )
   }

   fun getGoals(): List<Goal> {
      return goalRepository.findAll()
   }

   fun getGoal(goalId: Long): Optional<Goal> {
      return goalRepository.findById(goalId)
   }

   fun updateGoal(goal: Goal): Goal {
      return goalRepository.save(goal)
   }
}