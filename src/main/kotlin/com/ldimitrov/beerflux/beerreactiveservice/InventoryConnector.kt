package com.ldimitrov.beerflux.beerreactiveservice

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class InventoryConnector(@Value("\${inventory-service-url}") private val url: String) {

    val list = listOf(RemoteBeer("a", "b")).javaClass
    val restTemplate = RestTemplate()

    fun isBeerAvailable(name: String): Boolean {
        val serviceUrl = "${url}/beers"
        println("serviceUrl: ${serviceUrl}")
        return restTemplate.getForObject(serviceUrl, list)
                ?.filter { name == it.name }
                ?.isNotEmpty() ?: false
    }
}

data class RemoteBeer(val id: String, val name: String)