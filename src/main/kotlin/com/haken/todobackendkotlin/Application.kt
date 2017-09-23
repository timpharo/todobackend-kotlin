package com.haken.todobackendkotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer



@SpringBootApplication
class Application

object Config {
    var root: String = "http://localhost:8080"
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}

@Bean
fun corsConfigurer(): WebMvcConfigurer {
    return object : WebMvcConfigurerAdapter() {
        override fun addCorsMappings(registry: CorsRegistry) {
            registry.addMapping("/*")
                    .allowedOrigins("*")
                    .allowedHeaders("Content-Type")
        }
    }
}