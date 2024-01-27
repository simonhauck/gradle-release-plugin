package com.github.cryptojuenger.template.server

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExampleControllerTest {

    private val exampleController = ExampleController()

    @Test
    fun helloWorld() {
        val actual = exampleController.helloWorld()

        Thread.sleep(15_000)

        assertThat(actual).isEqualTo(HelloWorld("CryptoJuenger are the best"))
    }
}
