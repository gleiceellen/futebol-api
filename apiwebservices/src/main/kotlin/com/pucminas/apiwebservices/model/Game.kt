package com.pucminas.apiwebservices.model

import javax.persistence.*

@Entity
class Game(
        @Id
        @GeneratedValue
        @Column(name = "id", nullable = false)
        var id: Long? = null,

        @OneToOne
        val ownerClub: Club,

        @OneToOne
        val guestClub: Club,

        val date: String,
        var startTime: String? = null,
        var endTime: String? = null,

        @ManyToOne
        var contest: Contest? = null,

        @OneToMany(cascade = [CascadeType.ALL])
        var goals: MutableList<Goal> = mutableListOf(),

        @OneToMany(cascade = [CascadeType.ALL])
        var intervalls: MutableList<Intervall> = mutableListOf(),

        @OneToMany(cascade = [CascadeType.ALL])
        var increments: MutableList<Increment> = mutableListOf(),

        @OneToMany(cascade = [CascadeType.ALL])
        var warnings: MutableList<Warning> = mutableListOf(),

        @OneToMany(cascade = [CascadeType.ALL])
        var replacements: MutableList<Replacement> = mutableListOf()
)