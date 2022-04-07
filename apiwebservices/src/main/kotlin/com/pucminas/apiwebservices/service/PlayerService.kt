package com.pucminas.apiwebservices.service

import com.pucminas.apiwebservices.model.Player
import com.pucminas.apiwebservices.repository.PlayerRepository
import org.springframework.stereotype.Service

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
}