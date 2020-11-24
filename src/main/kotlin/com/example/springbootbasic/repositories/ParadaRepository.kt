package com.example.springbootbasic.repositories

import com.example.springbootbasic.model.Parada
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ParadaRepository: JpaRepository<Parada, Int>