package com.example.springbootbasic.controller

import com.example.springbootbasic.model.Rota
import com.example.springbootbasic.repositories.RotaRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/rotas")
class RotaController(
        private val rotaRepository: RotaRepository
) {

    @PostMapping
    fun new(@RequestBody rota: Rota): ResponseEntity<Rota> {
        val novaRota = rotaRepository.save(rota)
        return ResponseEntity.ok(novaRota)
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<Rota>> {
        val rotas = rotaRepository.findAll()
        return ResponseEntity.ok(rotas)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): ResponseEntity<Optional<Rota>> {
        val rota = rotaRepository.findById(id)
        return if (rota.isPresent) {
            ResponseEntity.ok(rota)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable id: Int) {
        rotaRepository.deleteById(id)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody novaRota: Rota): ResponseEntity<Rota> {
        return rotaRepository.findById(id)
                .map { rota ->
                    val novaVersaoDaRota = novaRota.copy(id = rota.id, paradas = rota.paradas)
                    rotaRepository.save(novaVersaoDaRota)
                    ResponseEntity.ok(novaVersaoDaRota)
                }
                .orElse(ResponseEntity.notFound().build())
    }

}