package org.itamar.mapstructkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MapstructApplication

fun main(args: Array<String>) {
    runApplication<MapstructApplication>(*args)
}

