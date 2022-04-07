package com.pucminas.apiwebservices.service

import com.pucminas.apiwebservices.exception.GameCreateException
import com.pucminas.apiwebservices.model.Warning
import com.pucminas.apiwebservices.model.request.*
import org.springframework.stereotype.Service

@Service
class WarningService(
        private val playerService: PlayerService
) {

   fun createWarning(warningInsertDto: WarningInsertDto): Warning {
      val player = playerService.getPlayer(warningInsertDto.playerId)

      player ?: throw GameCreateException(GameCreateException.PLAYER_NOT_FOUND)

      return Warning(
           time = warningInsertDto.time,
           type = warningInsertDto.type,
           player = player
      )
   }
}