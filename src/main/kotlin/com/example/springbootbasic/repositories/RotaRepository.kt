package com.example.springbootbasic.repositories

import com.example.springbootbasic.model.Rota
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RotaRepository: JpaRepository<Rota, Int>