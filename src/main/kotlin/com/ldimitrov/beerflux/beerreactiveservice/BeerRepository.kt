package com.ldimitrov.beerflux.beerreactiveservice

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface BeerRepository : ReactiveCrudRepository<Beer, String>