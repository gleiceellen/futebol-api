package com.pucminas.apiwebservices.model.reponse

import com.pucminas.apiwebservices.model.Intervall

data class IntervalResponseDto(
    val time: String,
    val amount: Long
)
{
    companion object {
        fun fromInterval(intervall: Intervall): IntervalResponseDto {
            return IntervalResponseDto(
                    time = intervall.time,
                    amount = intervall.amount
            )
        }
    }
}
