package com.pucminas.apiwebservices.service

import com.pucminas.apiwebservices.exception.GameCreateException
import com.pucminas.apiwebservices.exception.GameEventException
import com.pucminas.apiwebservices.model.Goal
import com.pucminas.apiwebservices.model.Replacement
import com.pucminas.apiwebservices.model.request.*
import com.pucminas.apiwebservices.repository.GoalRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ReplacementService(
    private val goalRepository: GoalRepository,
    private val playerService: PlayerService,
    private val clubService: ClubService
) {

   fun createReplacement(replacementInsertDto: ReplacementInsertDto): Replacement {
      val playerIn = playerService.getPlayer(replacementInsertDto.playerInId)
              ?: throw GameEventException(GameCreateException.PLAYER_NOT_FOUND)

      val playerOut = playerService.getPlayer(replacementInsertDto.playerOutId)
              ?: throw GameEventException(GameCreateException.PLAYER_NOT_FOUND)

      val club = clubService.getClub(replacementInsertDto.clubId)
              ?: throw GameEventException(GameCreateException.CLUB_NOT_FOUND)

      return Replacement(
              playerIn = playerIn,
              playerOut = playerOut,
              club = club,
              date = replacementInsertDto.date
      )
   }
}