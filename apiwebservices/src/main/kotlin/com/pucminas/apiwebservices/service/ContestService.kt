package com.pucminas.apiwebservices.service

import com.pucminas.apiwebservices.exception.GameCreateException
import com.pucminas.apiwebservices.exception.GameEventException
import com.pucminas.apiwebservices.model.Contest
import com.pucminas.apiwebservices.model.Game
import com.pucminas.apiwebservices.model.request.*
import com.pucminas.apiwebservices.repository.ContestRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class ContestService(
    private val contestRepository: ContestRepository,
    private val gameService: GameService,
    private val goalService: GoalService

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

   fun startGame(contestId: Long, gameId: Long): Game {
      val contestSearch = contestRepository.findById(contestId)

      if(contestSearch.isPresent.not())
         throw GameEventException(GameEventException.CONTEST_NOT_FOUND)

      val gameSearch = gameService.getGame(gameId)

      if(gameSearch.isPresent.not())
         throw GameEventException(GameEventException.GAME_NOT_FOUND)

      val game = gameSearch.get()

      if(game.startTime != null)
         throw GameEventException(GameEventException.GAME_ALREADY_STARTED)

      game.startTime = LocalDateTime.now().toString()

      return gameService.updateGame(game)
   }

   fun finishGame(contestId: Long, gameId: Long): Game {
      val contestSearch = contestRepository.findById(contestId)

      if(contestSearch.isPresent.not())
         throw GameEventException(GameEventException.CONTEST_NOT_FOUND)

      val gameSearch = gameService.getGame(gameId)

      if(gameSearch.isPresent.not())
         throw GameEventException(GameEventException.GAME_NOT_FOUND)

      val game = gameSearch.get()

      game.startTime ?:
         throw GameEventException(GameEventException.GAME_NOT_STARTED)

      if(game.endTime != null)
         return game

      game.endTime = LocalDateTime.now().toString()

      return gameService.updateGame(game)
   }

   fun registerGoal(contestId: Long, gameId: Long, goalInsertDto: GoalInsertDto): Game {
      val contestSearch = contestRepository.findById(contestId)

      if(contestSearch.isPresent.not())
         throw GameEventException(GameEventException.CONTEST_NOT_FOUND)

      val gameSearch = gameService.getGame(gameId)

      if(gameSearch.isPresent.not())
         throw GameEventException(GameEventException.GAME_NOT_FOUND)

      val game = gameSearch.get()

      validateIfGameIsRunning(game)

      val newGoal = goalService.createGoal(goalInsertDto)
      newGoal.game = game
      game.goals.add(newGoal)

      return gameService.updateGame(game)
   }

   private fun validateIfGameIsRunning(game: Game) {
      if (game.startTime == null)
         throw GameEventException(GameEventException.GAME_NOT_STARTED)

      if (game.endTime != null)
         throw GameEventException(GameEventException.GAME_ALREADY_FINISHED)
   }
}