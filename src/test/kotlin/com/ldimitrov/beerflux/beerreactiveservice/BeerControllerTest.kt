package com.ldimitrov.beerflux.beerreactiveservice

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.returnResult
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

@RunWith(SpringRunner::class)
@WebFluxTest(*arrayOf(BeerService::class, BeerController::class))
class BeerControllerTest {

    @Autowired
    lateinit var client: WebTestClient

    @MockBean
    lateinit var repo: BeerRepository

    private val beer1 = Beer("id1", "Favourite Beer")
    private val beer2 = Beer("id2", "Another Beer")

    @Before
    fun setup() {
        Mockito.`when`(repo.findAll()).thenReturn(Flux.just(beer1, beer2))
        Mockito.`when`(repo.findById(beer1.id!!)).thenReturn(Mono.just(beer1))
        Mockito.`when`(repo.findById(beer2.id!!)).thenReturn(Mono.just(beer2))
    }

    @Test
    fun `Get all beers`() {
        StepVerifier.create(client.get()
                .uri("/beers")
                .exchange()
                .expectStatus().isOk
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .returnResult<Beer>()
                .responseBody)
                .expectNext(beer1)
                .expectNext(beer2)
                .verifyComplete()
    }

    @Test
    fun `Get a particular beer by Id`() {
        StepVerifier.create(client.get()
                .uri("/beers/{id}", beer2.id)
                .exchange()
                .expectStatus().isOk
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .returnResult<Beer>()
                .responseBody)
                .expectNext(beer2)
                .verifyComplete()
    }

    @Test
    fun `Get some orders for a particular coffee`() {
        StepVerifier.create(client.get()
                .uri("/beers/{id}/orders", beer1.id)
                .exchange()
                .expectStatus().isOk
                .expectHeader().contentType(MediaType.TEXT_EVENT_STREAM_VALUE + ";charset=UTF-8")
                .returnResult<Beer>()
                .responseBody
                .take(2))
                .expectNextCount(2)
                .verifyComplete()
    }

}