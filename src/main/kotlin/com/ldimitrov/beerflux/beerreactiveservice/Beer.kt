package com.ldimitrov.beerflux.beerreactiveservice

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Beer(@Id val id: String? = null, val name: String = "Craft Beer")