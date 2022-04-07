package com.pucminas.apiwebservices.model

import javax.persistence.*

@Entity
class Increment(
        @Id
        @GeneratedValue
        @Column(name = "id", nullable = false)
        var id: Long? = null,

        @ManyToOne
        var game: Game? = null,

        val time: String,
        val amount: Long
)