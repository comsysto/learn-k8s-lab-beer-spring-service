package com.ldimitrov.beerflux.beerreactiveservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BeerReactiveServiceApplication

fun main(args: Array<String>) {
    runApplication<BeerReactiveServiceApplication>(*args)
}
