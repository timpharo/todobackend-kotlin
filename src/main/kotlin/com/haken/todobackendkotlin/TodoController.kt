package com.haken.todobackendkotlin

import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.concurrent.atomic.AtomicLong

@RestController
@CrossOrigin
class TodoController(val todoRepository: TodoRepository) {

    val counter = AtomicLong()

    @GetMapping
    fun rootGet() : MutableIterable<Todo>? = todoRepository.findAll()

    @PostMapping
    fun postTodo(@RequestBody todo : Todo) : Todo{
        val newId = counter.getAndIncrement()
        todo.id = newId

        todo.url = "${Config.root}/todo/$newId"
        return todoRepository.save(todo)
    }

    @DeleteMapping
    fun deleteTodo() = todoRepository.deleteAll()

    @GetMapping("/todo/{id}")
    fun getTodo(@PathVariable("id") id : Long) : Todo? = todoRepository.findOne(id)

    @PatchMapping("/todo/{id}")
    fun patchTodo(@PathVariable("id") id : Long, @RequestBody todo : Todo) : Todo{
        val retrievedTodo = todoRepository.findOne(id)

        if(todo.title != "") {
            retrievedTodo.title = todo.title
        }

        if(todo.completed) {
            retrievedTodo.completed = todo.completed
        }
        return todoRepository.save(retrievedTodo)
    }

}
