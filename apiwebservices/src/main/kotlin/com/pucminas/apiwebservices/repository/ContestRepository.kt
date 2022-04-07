package com.pucminas.apiwebservices.repository;

import com.pucminas.apiwebservices.model.Contest
import org.springframework.data.jpa.repository.JpaRepository


interface ContestRepository : JpaRepository<Contest, Long>