package com.ldimitrov.beerflux.beerreactiveservice

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.time.Instant

@Service
class BeerService(private val beerRepository: BeerRepository, private val connector: InventoryConnector) {
    fun getAllBeers() = beerRepository.findAll()

    fun findBeerById(id: String) = beerRepository.findById(id)

    fun getOrdersForBeerById(bearName: String) = if (connector.isBeerAvailable(bearName)) {
        Flux.just(BeerOrder(bearName, Instant.now()))
    } else {
        Flux.empty()
    }
}