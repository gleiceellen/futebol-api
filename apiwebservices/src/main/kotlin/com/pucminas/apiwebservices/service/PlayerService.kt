package com.pucminas.apiwebservices.service

import com.pucminas.apiwebservices.repository.PlayerRepository
import org.springframework.stereotype.Service

@Service
class PlayerService(
    private val playerRepository: PlayerRepository
) {}