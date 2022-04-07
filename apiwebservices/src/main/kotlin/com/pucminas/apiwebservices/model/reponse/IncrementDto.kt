package com.pucminas.apiwebservices.model.reponse

import com.pucminas.apiwebservices.model.Increment

data class IncrementResponseDto(
    val time: String,
    val amount: Long
)
{
    companion object {
        fun fromIncrement(increment: Increment): IncrementResponseDto {
            return IncrementResponseDto(
                    time = increment.time,
                    amount = increment.amount
            )
        }
    }
}
