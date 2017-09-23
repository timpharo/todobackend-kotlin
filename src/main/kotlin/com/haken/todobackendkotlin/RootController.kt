package com.haken.todobackendkotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class RootController {

    val counter = AtomicLong()

    @GetMapping
    fun root() = "Hello"

}
