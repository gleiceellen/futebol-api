package com.pucminas.apiwebservices.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class Transfer(
        @Id
        @GeneratedValue
        @Column(name = "id", nullable = false)
        var id: Long? = null,

        @OneToOne
        val originClub: Club,

        @OneToOne
        val destinationClub: Club,

        @OneToOne
        val player: Player,

        val date: String,
        val amount: String
)