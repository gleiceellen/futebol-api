package com.pucminas.apiwebservices.repository;


import com.pucminas.apiwebservices.model.Club
import org.springframework.data.jpa.repository.JpaRepository

interface ClubRepository : JpaRepository<Club, Long> {
}