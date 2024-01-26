package com.github.cryptojuenger.template.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/example")
class ExampleController {
    @GetMapping()
    fun helloWorld(): HelloWorld {
        return HelloWorld("CryptoJuenger are the best")
    }
}

data class HelloWorld(val message: String)

@SpringBootApplication class ServerApplication

fun main(args: Array<String>) {
    runApplication<ServerApplication>(*args)
}
