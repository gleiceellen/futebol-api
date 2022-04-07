package com.pucminas.apiwebservices.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Club(
        @Id
        @GeneratedValue
        @Column(name = "id", nullable = false)
        var id: Long? = null,
        val name: String,
        val location: String,
)