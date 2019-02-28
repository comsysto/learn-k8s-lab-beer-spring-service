package com.ldimitrov.beerflux.beerreactiveservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController() {

    @GetMapping("/")
    fun health() = "healthy"

    @GetMapping("/hello")
    fun hello() = "Hello!"
}