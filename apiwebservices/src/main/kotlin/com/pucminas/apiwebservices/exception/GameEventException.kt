package com.pucminas.apiwebservices.exception

class GameEventException(override val message: String): RuntimeException(message ) {
    companion object {
        const val GAME_NOT_FOUND = "game not found"
        const val CONTEST_NOT_FOUND = "contest club not found"
        const val GAME_NOT_STARTED = "game not started"
        const val GAME_ALREADY_STARTED = "game already started"
        const val GAME_ALREADY_FINISHED = "game already finished"
    }
}
