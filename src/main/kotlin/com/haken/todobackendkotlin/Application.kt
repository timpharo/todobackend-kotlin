package com.haken.todobackendkotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class Application

object Config {
    var root: String = "http://localhost:8080"

    init {
        System.getenv("BASE_URL").let { root = it }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
