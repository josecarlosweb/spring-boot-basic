package com.example.springbootbasic.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Rota(
        @Id
        @GeneratedValue
        val id: Int? = null,
        val nome: String? = null,
        @OneToMany(mappedBy = "rota")
        val paradas: List<Parada> = emptyList()
)