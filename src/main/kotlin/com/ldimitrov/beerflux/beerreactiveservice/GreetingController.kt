package com.ldimitrov.beerflux.beerreactiveservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController() {

    @GetMapping("/hello")
    fun hello() = "Hello!"
}