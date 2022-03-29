package com.pucminas.apiwebservices.service

import com.pucminas.apiwebservices.repository.ClubRepository
import org.springframework.stereotype.Service

@Service
class ClubService(
    private val clubRepository: ClubRepository
){}