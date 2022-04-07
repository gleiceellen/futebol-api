package com.pucminas.apiwebservices.model

import javax.persistence.*

@Entity
class Contest(
        @Id
        @GeneratedValue
        @Column(name = "id", nullable = false)
        var id: Long? = null,
        val name: String,
        val startDate: String,
        val finishDate: String,

        @OneToMany(cascade = [CascadeType.ALL])
        val games: MutableList<Game> = mutableListOf()
)