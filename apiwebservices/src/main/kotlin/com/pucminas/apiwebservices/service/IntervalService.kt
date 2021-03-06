package com.pucminas.apiwebservices.service

import com.pucminas.apiwebservices.model.Intervall
import com.pucminas.apiwebservices.model.request.*
import com.pucminas.apiwebservices.model.request.IntervalInsertDto.Companion.toInterval
import com.pucminas.apiwebservices.repository.GoalRepository
import org.springframework.stereotype.Service

@Service
class IntervalService(
) {

   fun createInterval(intervalInsertDto: IntervalInsertDto): Intervall {
      return toInterval(intervalInsertDto)
   }
}