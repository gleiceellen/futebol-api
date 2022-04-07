package com.pucminas.apiwebservices.model.request

import com.pucminas.apiwebservices.model.Increment
import com.pucminas.apiwebservices.model.Intervall

data class IncrementInsertDto(
    val time: String,
    val amount: Long
) {
    companion object{
        fun toIncrement(incrementInsertDto: IncrementInsertDto) = Increment(
                time = incrementInsertDto.time,
                amount = incrementInsertDto.amount
        )
    }
}
