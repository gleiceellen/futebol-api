package com.pucminas.apiwebservices.repository;

import com.pucminas.apiwebservices.model.Contest
import com.pucminas.apiwebservices.model.Game
import org.springframework.data.jpa.repository.JpaRepository


interface GameRepository : JpaRepository<Game, Long>