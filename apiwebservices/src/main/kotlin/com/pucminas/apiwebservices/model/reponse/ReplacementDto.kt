package com.pucminas.apiwebservices.model.reponse

import com.pucminas.apiwebservices.model.Replacement

data class ReplacementResponseDto(
    val club: ClubPartialResponseDto,
    val playerIn: PlayerPartialResponseDto,
    val playerOut: PlayerPartialResponseDto,
    val date: String
)
{
    companion object {
        fun fromReplacement(replacement: Replacement): ReplacementResponseDto {
            return ReplacementResponseDto(
                    club = ClubPartialResponseDto.fromClub(replacement.club),
                    playerIn = PlayerPartialResponseDto.fromPlayer(replacement.playerIn ),
                    playerOut = PlayerPartialResponseDto.fromPlayer(replacement.playerOut ),
                    date = replacement.date
            )
        }
    }
}


