package com.ldimitrov.beerflux.beerreactiveservice

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate


@Component
class InventoryConnector(@Value("\${inventory-service-url}") private val url: String) {

    val restTemplate = RestTemplate()

    fun isBeerAvailable(name: String): Boolean {
        val serviceUrl = "${url}/beers"
        return restTemplate.getForObject(serviceUrl, Array<RemoteBeer>::class.java)
                ?.any { name == it.name }
                ?: false
    }
}

data class RemoteBeer(val id: String, val name: String)