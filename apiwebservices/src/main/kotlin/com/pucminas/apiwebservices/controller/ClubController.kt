package com.pucminas.apiwebservices.controller

import com.pucminas.apiwebservices.service.ClubService
import org.springframework.web.bind.annotation.RestController

@RestController
class ClubController(
    private val clubService: ClubService
) {}