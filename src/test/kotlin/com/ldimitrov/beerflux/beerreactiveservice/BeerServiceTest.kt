package com.ldimitrov.beerflux.beerreactiveservice

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.DisabledIf
import org.springframework.test.context.junit4.SpringRunner
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

//@RunWith(SpringRunner::class)
//@WebFluxTest(BeerService::class)
class BeerServiceTest {

    @Autowired
    lateinit var service: BeerService

    @MockBean
    lateinit var repository: BeerRepository

    private val beer1 = Beer("id1", "Favourite Beer")
    private val beer2 = Beer("id2", "Another Beer")

    @Before
    fun setup() {
        Mockito.`when`(repository.findAll()).thenReturn(Flux.just(beer1, beer2))
        Mockito.`when`(repository.findById(beer1.id!!)).thenReturn(Mono.just(beer1))
        Mockito.`when`(repository.findById(beer2.id!!)).thenReturn(Mono.just(beer2))
    }

    //@Test
    @DisabledIf("true")
    fun `Get all beers`() {
        StepVerifier.withVirtualTime { service.getAllBeers() }
                .expectNext(beer1)
                .expectNext(beer2)
                .verifyComplete()
    }

    //@Test
    @DisabledIf("true")
    fun `Find Beer ById`() {
        StepVerifier.withVirtualTime { service.findBeerById(beer1.id!!) }
                .expectNext(beer1)
                .verifyComplete()
    }
}