package com.pucminas.apiwebservices.model

import javax.persistence.*

@Entity
class Club(
        @Id
        @GeneratedValue
        @Column(name = "id", nullable = false)
        var id: Long? = null,
        val name: String,
        val location: String,

        @OneToMany(cascade = [CascadeType.ALL])
        val players: List<Player> = emptyList()
)