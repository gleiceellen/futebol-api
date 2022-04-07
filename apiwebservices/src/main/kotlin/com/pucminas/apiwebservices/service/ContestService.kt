package com.pucminas.apiwebservices.service

import com.pucminas.apiwebservices.exception.PlayerUpdateException
import com.pucminas.apiwebservices.model.Contest
import com.pucminas.apiwebservices.model.Player
import com.pucminas.apiwebservices.model.request.ContestInsertDto
import com.pucminas.apiwebservices.model.request.PlayerUpdateDto
import com.pucminas.apiwebservices.model.request.toContest
import com.pucminas.apiwebservices.model.request.toPlayer
import com.pucminas.apiwebservices.repository.ContestRepository
import com.pucminas.apiwebservices.repository.PlayerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ContestService(
    private val contestRepository: ContestRepository
) {

   fun createContest(contestInsertDto: ContestInsertDto): Contest {
      val contest = contestInsertDto.toContest()
      return contestRepository.save(contest)
   }

   fun getContests(): List<Contest> {
      return contestRepository.findAll()
   }
}