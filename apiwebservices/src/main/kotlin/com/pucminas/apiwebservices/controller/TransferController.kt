package com.pucminas.apiwebservices.controller

import com.pucminas.apiwebservices.service.TransferService
import org.springframework.web.bind.annotation.RestController

@RestController
class TransferController(
    private val transferService: TransferService
) {}