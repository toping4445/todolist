package com.kakaopaycorp.todolist.service

import com.kakaopaycorp.todolist.repository.ToDo
import com.kakaopaycorp.todolist.repository.ToDoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ToDoService (
    private val toDoRepository: ToDoRepository
) {
    fun getToDos() = toDoRepository.findAll()

    fun insertToDo(toDoName : String) = toDoRepository.save(ToDo(toDoName = toDoName))

    fun updateToDo(toDoId : Long): ToDo {
        val toDo = toDoRepository.findByIdOrNull(toDoId) ?: throw Exception()
        toDo.completed = !toDo.completed
        return toDoRepository.save(toDo)
    }

    fun deleteToDo(toDoId: Long) = toDoRepository.deleteById(toDoId)

}