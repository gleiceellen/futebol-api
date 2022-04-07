package com.pucminas.apiwebservices.exception

class GameEventException(override val message: String): RuntimeException(message ) {
    companion object {
        const val GAME_NOT_FOUND = "game not found"
        const val CONTEST_NOT_FOUND = "contest club not found"
    }
}
