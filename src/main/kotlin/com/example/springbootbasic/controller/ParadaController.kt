package com.example.springbootbasic.controller

import com.example.springbootbasic.model.Parada
import com.example.springbootbasic.model.Rota
import com.example.springbootbasic.repositories.ParadaRepository
import com.example.springbootbasic.repositories.RotaRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/paradas")
class ParadaController(
        private val paradaRepository: ParadaRepository,
        private val rotaRepository: RotaRepository
) {

    @PostMapping("/{rotaId}")
    fun addStop(@PathVariable rotaId: Int, @RequestBody parada: Parada): ResponseEntity<Parada>{
        return if(rotaRepository.existsById(rotaId)){
            val novaParada = parada.copy(rota = Rota(id = rotaId))
            paradaRepository.save(novaParada)
            ResponseEntity.ok(novaParada)
        }else{
            ResponseEntity(HttpStatus.PRECONDITION_FAILED)
        }
    }

    @DeleteMapping("/{rotaId}/{paradaId}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteStop(@PathVariable rotaId: Int, @PathVariable paradaId: Int){
        if(rotaRepository.existsById(rotaId)){
            paradaRepository.deleteById(paradaId)
        }
    }

}