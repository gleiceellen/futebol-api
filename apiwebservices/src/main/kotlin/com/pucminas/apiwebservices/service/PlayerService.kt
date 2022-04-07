package com.pucminas.apiwebservices.service

import com.pucminas.apiwebservices.exception.PlayerUpdateException
import com.pucminas.apiwebservices.model.Player
import com.pucminas.apiwebservices.model.request.PlayerUpdateDto
import com.pucminas.apiwebservices.model.request.toPlayer
import com.pucminas.apiwebservices.repository.PlayerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PlayerService(
    private val playerRepository: PlayerRepository
) {

    fun getPLayers(): List<Player> {
        return playerRepository.findAll()
    }

    fun getPlayer(playerId: Long): Player? {
        val search = playerRepository.findById(playerId)

        return if(search.isPresent)
            search.get()
        else
            null
    }

    fun deletePlayer(playerId: Long) {
        playerRepository.deleteById(playerId)
    }

    fun updatePlayer(player: Player) {
        playerRepository.save(player)
    }

    fun updatePlayer(playerId: Long, playerUpdateDto: PlayerUpdateDto): Player {
        val search = playerRepository.findById(playerId)

        return if(search.isPresent){
            updateExistentPlayer(search, playerUpdateDto)
        }
        else
            throw PlayerUpdateException(PlayerUpdateException.NOT_FOUND)

    }

    private fun updateExistentPlayer(search: Optional<Player>, playerUpdateDto: PlayerUpdateDto): Player {
        val storedPlayer = search.get()
        val updatedPlayer = playerUpdateDto.toPlayer(storedPlayer)
        return playerRepository.save(updatedPlayer)
    }
}