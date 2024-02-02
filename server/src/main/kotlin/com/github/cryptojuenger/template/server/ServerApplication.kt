package com.github.cryptojuenger.template.server

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private val log = KotlinLogging.logger {}

@RestController
@RequestMapping("/api/example")
class ExampleController {
    @GetMapping()
    fun helloWorld(): HelloWorld {
        log.info { "this is a log entry" }
        return HelloWorld("CryptoJuenger are the best")
    }
}

data class HelloWorld(val message: String)

@SpringBootApplication class ServerApplication

fun main(args: Array<String>) {
    runApplication<ServerApplication>(*args)
}
