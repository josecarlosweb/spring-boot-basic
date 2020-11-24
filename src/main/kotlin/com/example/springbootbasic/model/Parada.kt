package com.example.springbootbasic.model

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
data class Parada(
        @Id
        @GeneratedValue
        val id: Int? = null,
        val nomeCliente: String? = null,
        val endereco: String? = null,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "rota_id", nullable = false)
        @JsonBackReference
        val rota: Rota = Rota()
)