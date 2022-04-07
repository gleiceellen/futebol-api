package com.pucminas.apiwebservices.exception

class TransferCreateException(override val message: String): RuntimeException(message ) {
    companion object {
        const val PLAYER_NOT_FOUND = "player not found"
        const val ORIGIN_CLUB_NOT_FOUND = "origin club not found"
        const val DESTINATION_CLUB_NOT_FOUND = "destination club not found"
    }
}
