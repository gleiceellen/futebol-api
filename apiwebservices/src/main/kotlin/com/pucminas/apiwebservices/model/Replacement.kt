package com.pucminas.apiwebservices.model

import javax.persistence.*

@Entity
class Replacement(
        @Id
        @GeneratedValue
        @Column(name = "id", nullable = false)
        var id: Long? = null,

        @ManyToOne
        var game: Game? = null,

        @OneToOne
        val club: Club,

        @OneToOne
        val playerIn: Player,

        @OneToOne
        val playerOut: Player,

        val date: String
)