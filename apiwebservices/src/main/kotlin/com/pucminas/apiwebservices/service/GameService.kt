package com.pucminas.apiwebservices.service

import com.pucminas.apiwebservices.exception.GameCreateException
import com.pucminas.apiwebservices.exception.PlayerUpdateException
import com.pucminas.apiwebservices.model.Contest
import com.pucminas.apiwebservices.model.Game
import com.pucminas.apiwebservices.model.Player
import com.pucminas.apiwebservices.model.request.*
import com.pucminas.apiwebservices.repository.ContestRepository
import com.pucminas.apiwebservices.repository.GameRepository
import com.pucminas.apiwebservices.repository.PlayerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class GameService(
    private val gameRepository: GameRepository,
    private val clubService: ClubService
) {

   fun createGame(gameInsertDto: GameInsertDto): Game {
      val owner = clubService.getClub(gameInsertDto.ownerClubId)
              ?: throw GameCreateException(GameCreateException.OWNER_CLUB_NOT_FOUND)

      val guest = clubService.getClub(gameInsertDto.guestClubId)
              ?: throw GameCreateException(GameCreateException.GUEST_CLUB_NOT_FOUND)

      return Game(
              ownerClub = owner,
              guestClub = guest,
              date = gameInsertDto.date
      )
   }

   fun getGames(): List<Game> {
      return gameRepository.findAll()
   }
}