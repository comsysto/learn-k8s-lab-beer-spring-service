package com.ldimitrov.beerflux.beerreactiveservice

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/beers")
class BeerController(private val service: BeerService) {
    @GetMapping
    fun allBeers() = service.getAllBeers()

    @GetMapping("/{id}")
    fun beerById(@PathVariable id: String) = service.findBeerById(id)

    @GetMapping("/{id}/orders", produces = arrayOf(MediaType.TEXT_EVENT_STREAM_VALUE))
    fun findOrders(@PathVariable id: String) = service.getOrdersForBeerById(id)
}