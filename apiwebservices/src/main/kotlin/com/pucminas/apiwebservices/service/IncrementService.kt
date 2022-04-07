package com.pucminas.apiwebservices.service

import com.pucminas.apiwebservices.model.Increment
import com.pucminas.apiwebservices.model.Intervall
import com.pucminas.apiwebservices.model.request.*
import com.pucminas.apiwebservices.model.request.IncrementInsertDto.Companion.toIncrement
import com.pucminas.apiwebservices.model.request.IntervalInsertDto.Companion.toInterval
import com.pucminas.apiwebservices.repository.GoalRepository
import org.springframework.stereotype.Service

@Service
class IncrementService(
) {

   fun createIncrement(incrementInsertDto: IncrementInsertDto): Increment {
      return toIncrement(incrementInsertDto)
   }
}