package com.pucminas.apiwebservices.model

import javax.persistence.*

@Entity
class Game(
        @Id
        @GeneratedValue
        @Column(name = "id", nullable = false)
        var id: Long? = null
)