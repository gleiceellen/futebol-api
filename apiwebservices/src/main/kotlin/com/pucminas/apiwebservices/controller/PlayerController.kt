package com.pucminas.apiwebservices.controller

import com.pucminas.apiwebservices.service.PlayerService
import org.springframework.web.bind.annotation.RestController

@RestController
class PlayerController(
    private val playerService: PlayerService
){}