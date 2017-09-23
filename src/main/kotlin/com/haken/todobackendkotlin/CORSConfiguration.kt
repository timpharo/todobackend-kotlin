package com.haken.todobackendkotlin

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter


@Configuration
class AppConfig : WebMvcConfigurerAdapter() {

    override fun addCorsMappings(registry: CorsRegistry) {

        registry.addMapping("/")
                .allowedOrigins("*")
                .allowedMethods("OPTIONS", "POST", "GET", "PUT", "DELETE")
                .allowedHeaders("Content-Type")


    }
}