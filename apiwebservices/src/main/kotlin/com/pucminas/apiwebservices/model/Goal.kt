package com.pucminas.apiwebservices.model

import javax.persistence.*

@Entity
class Goal(
        @Id
        @GeneratedValue
        @Column(name = "id", nullable = false)
        var id: Long? = null,

        @ManyToOne
        var game: Game? = null,

        @OneToOne
        val club: Club,

        @OneToOne
        val player: Player,

        val date: String
)