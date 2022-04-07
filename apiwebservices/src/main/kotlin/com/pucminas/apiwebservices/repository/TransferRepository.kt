package com.pucminas.apiwebservices.repository;

import com.pucminas.apiwebservices.model.Transfer
import org.springframework.data.jpa.repository.JpaRepository


interface TransferRepository : JpaRepository<Transfer, Long>