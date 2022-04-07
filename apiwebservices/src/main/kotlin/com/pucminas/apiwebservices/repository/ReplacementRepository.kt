package com.pucminas.apiwebservices.repository;


import com.pucminas.apiwebservices.model.Increment
import com.pucminas.apiwebservices.model.Intervall
import com.pucminas.apiwebservices.model.Replacement
import com.pucminas.apiwebservices.model.Warning
import org.springframework.data.jpa.repository.JpaRepository

interface ReplacementRepository : JpaRepository<Replacement, Long> {
}