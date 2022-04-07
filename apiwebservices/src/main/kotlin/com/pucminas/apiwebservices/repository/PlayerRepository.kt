package com.pucminas.apiwebservices.repository;

import com.pucminas.apiwebservices.model.Player
import org.springframework.data.jpa.repository.JpaRepository

interface PlayerRepository : JpaRepository<Player, Long>