package com.pucminas.apiwebservices.repository;


import com.pucminas.apiwebservices.model.Club
import com.pucminas.apiwebservices.model.Goal
import org.springframework.data.jpa.repository.JpaRepository

interface GoalRepository : JpaRepository<Goal, Long> {
}