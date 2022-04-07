package com.pucminas.apiwebservices.model.request

import com.pucminas.apiwebservices.model.Intervall

data class IntervalInsertDto(
    val time: String,
    val amount: Long
) {
    companion object{
        fun toInterval(intervalInsertDto: IntervalInsertDto) = Intervall(
                time = intervalInsertDto.time,
                amount = intervalInsertDto.amount
        )
    }
}
