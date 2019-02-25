package com.ldimitrov.beerflux.beerreactiveservice

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.time.Duration
import java.time.Instant

@Service
class BeerService(private val beerRepository: BeerRepository) {
    fun getAllBeers() = beerRepository.findAll()

    fun findBeerById(id: String) = beerRepository.findById(id)

    fun getOrdersForBeerById(beerId: String) = Flux.interval(Duration.ofSeconds(1))
            .onBackpressureDrop()
            .map { BeerOrder(beerId, Instant.now()) }
}