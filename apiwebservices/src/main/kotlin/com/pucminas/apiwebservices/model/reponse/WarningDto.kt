package com.pucminas.apiwebservices.model.reponse

import com.pucminas.apiwebservices.model.Warning

data class WarningResponseDto(
    val time: String,
    val id: Long,
    val player: PlayerPartialResponseDto
)
{
    companion object {
        fun fromWarning(warning: Warning): WarningResponseDto {
            return WarningResponseDto(
                    time = warning.time,
                    id = warning.id!!,
                    player = PlayerPartialResponseDto.fromPlayer(warning.player)
            )
        }
    }
}
