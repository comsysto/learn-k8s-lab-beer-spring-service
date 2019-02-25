package com.ldimitrov.beerflux.beerreactiveservice

import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import javax.annotation.PostConstruct

@Component
class DataLoader(private val repository: BeerRepository) {
    @PostConstruct
    private fun loadBeers() = repository.deleteAll().thenMany(
            Flux.just("Cornet", "Augustiner", "Paulaner", "Duval", "Leffe", "Kilkenny")
                    .map { Beer(name = it) }
                    .flatMap { repository.save(it) })
            .thenMany(repository.findAll())
            .subscribe { println(it) }
}