package com.pucminas.apiwebservices.service

import com.pucminas.apiwebservices.exception.GameCreateException
import com.pucminas.apiwebservices.exception.PlayerUpdateException
import com.pucminas.apiwebservices.model.Contest
import com.pucminas.apiwebservices.model.Game
import com.pucminas.apiwebservices.model.Player
import com.pucminas.apiwebservices.model.request.*
import com.pucminas.apiwebservices.repository.ContestRepository
import com.pucminas.apiwebservices.repository.PlayerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ContestService(
    private val contestRepository: ContestRepository,
    private val gameService: GameService

) {

   fun createContest(contestInsertDto: ContestInsertDto): Contest {
      val contest = contestInsertDto.toContest()
      return contestRepository.save(contest)
   }

   fun getContests(): List<Contest> {
      return contestRepository.findAll()
   }

   fun createGame(contestId: Long, gameInsertDto: GameInsertDto): Game {
      val search = contestRepository.findById(contestId)

      if(search.isPresent){
         return createGameForExistentContest(search, gameInsertDto)
      }
      else{
         throw GameCreateException(GameCreateException.CONTEST_CLUB_NOT_FOUND)
      }

   }

   private fun createGameForExistentContest(search: Optional<Contest>, gameInsertDto: GameInsertDto): Game {
      val contest = search.get()

      val newGame = gameService.createGame(gameInsertDto)
      newGame.contest = contest

      contest.games.add(newGame)
      val updatedContest = contestRepository.save(contest)

      val savedGame = updatedContest.games.last()
      return savedGame
   }
}