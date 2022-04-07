package com.pucminas.apiwebservices.exception

class GameCreateException(override val message: String): RuntimeException(message ) {
    companion object {
        const val GUEST_CLUB_NOT_FOUND = "guest club not found"
        const val OWNER_CLUB_NOT_FOUND = "owner club not found"
        const val CONTEST_CLUB_NOT_FOUND = "contest club not found"
        const val PLAYER_NOT_FOUND = "player not found"
        const val CLUB_NOT_FOUND = "club not found"
    }
}
