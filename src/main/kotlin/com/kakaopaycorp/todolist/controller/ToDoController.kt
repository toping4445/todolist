package com.kakaopaycorp.todolist.controller

import com.kakaopaycorp.todolist.service.ToDoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todo")
class ToDoController(
    private val toDoService: ToDoService
) {

    @GetMapping
    fun getToDos() = toDoService.getToDos()

    @PostMapping
    fun insertToDo(@RequestBody toDoRequest : ToDoRequest) = toDoService.insertToDo(toDoRequest.toDoName)

    @PutMapping(path = ["/{toDoId}"])
    fun updateToDo(@PathVariable("toDoId") toDoId: Long) = toDoService.updateToDo(toDoId)

    @DeleteMapping(path = ["/{toDoId}"])
    fun deleteTodo(@PathVariable("toDoId") toDoId : Long) = toDoService.deleteToDo(toDoId)

}
