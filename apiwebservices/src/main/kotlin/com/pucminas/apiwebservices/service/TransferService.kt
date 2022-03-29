package com.pucminas.apiwebservices.service

import com.pucminas.apiwebservices.repository.TransferRepository
import org.springframework.stereotype.Service

@Service
class TransferService(
    private val transferRepository: TransferRepository
) {
}