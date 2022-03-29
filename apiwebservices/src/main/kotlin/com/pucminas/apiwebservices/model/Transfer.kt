package com.pucminas.futebolapi.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Transfer(
        @Id
        @Column(name = "id", nullable = false)
        var id: Long? = null,
        val originClub: String,
        val destinationClub: String,
        val date: String,
        val amount: String
)