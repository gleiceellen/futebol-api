package com.pucminas.apiwebservices.repository;

import com.pucminas.futebolapi.model.Transfer
import org.springframework.data.jpa.repository.JpaRepository

interface TransferRepository : JpaRepository<Transfer, Long>