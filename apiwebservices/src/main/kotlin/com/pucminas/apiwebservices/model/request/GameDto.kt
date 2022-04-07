package com.pucminas.apiwebservices.model.request

import com.pucminas.apiwebservices.model.Game


data class GameInsertDto(
    val ownerClubId: Long,
    val guestClubId: Long,
    val date: String
) {
    companion object {
        fun fromGame(game: Game): GameInsertDto {
            return GameInsertDto(
                    ownerClubId = game.ownerClub.id!!,
                    guestClubId = game.guestClub.id!!,
                    date = game.date
            )
        }
    }
}