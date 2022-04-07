package com.pucminas.apiwebservices.model

import javax.persistence.*

@Entity
class Player(
        @Id
        @GeneratedValue
        @Column(name = "id", nullable = false)
        var id: Long? = null,
        val name: String,
        val birthDate: String,
        val country: String,

        @ManyToOne
        var club: Club? = null
)