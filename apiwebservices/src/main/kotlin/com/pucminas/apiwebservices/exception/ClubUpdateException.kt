package com.pucminas.apiwebservices.exception

class ClubUpdateException(override val message: String): RuntimeException(message ) {
    companion object {
        const val CANT_UPDATE_OR_INSERT = "entity does not exists and cannot be added."
        const val NOT_FOUND = "club not found"
        const val PLAYER_ALREADY_REGISTERED = "player already registered"
    }
}