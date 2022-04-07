package com.pucminas.apiwebservices.repository;


import com.pucminas.apiwebservices.model.Intervall
import org.springframework.data.jpa.repository.JpaRepository

interface IntervalRepository : JpaRepository<Intervall, Long> {
}