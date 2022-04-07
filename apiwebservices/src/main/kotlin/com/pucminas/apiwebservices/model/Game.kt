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
        val startTime: String? = null,
        val endTime: String? = null,

        @ManyToOne
        var contest: Contest? = null
)