package com.pucminas.apiwebservices.model.reponse

import com.pucminas.apiwebservices.model.Player
import com.pucminas.apiwebservices.model.Transfer
import org.apache.juli.logging.Log

data class TransferResponseDto(
    val id: Long,
    val originClub: ClubPartialResponseDto,
    val destinationClub: ClubPartialResponseDto,
    val player: PlayerPartialResponseDto,
    val date: String,
    val amount: String,
)
{
    companion object {
        fun fromTransfer(transfer: Transfer): TransferResponseDto {
            return TransferResponseDto(
                id = transfer.id!!,
                originClub = ClubPartialResponseDto.fromClub(transfer.originClub),
                destinationClub = ClubPartialResponseDto.fromClub(transfer.destinationClub),
                player = PlayerPartialResponseDto.fromPlayer(transfer.player),
                date = transfer.date,
                amount = transfer.amount
            )
        }
    }
}


