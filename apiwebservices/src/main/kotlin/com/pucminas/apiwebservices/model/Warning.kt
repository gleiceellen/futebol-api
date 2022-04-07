package com.pucminas.apiwebservices.model

import javax.persistence.*

@Entity
class Warning(
        @Id
        @GeneratedValue
        @Column(name = "id", nullable = false)
        var id: Long? = null,

        @ManyToOne
        var game: Game? = null,

        val time: String,
        val type: String,

        @OneToOne
        val player: Player
)