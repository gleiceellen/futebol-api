package com.pucminas.apiwebservices.exception

class PlayerUpdateException(override val message: String): RuntimeException(message ) {
    companion object {
        const val CANT_UPDATE_OR_INSERT = "entity does not exists and cannot be added."
        const val NOT_FOUND = "player not found"
    }
}