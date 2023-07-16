package com.kakaopaycorp.todolist.repository

import org.springframework.data.repository.CrudRepository

interface ToDoRepository : CrudRepository<ToDo, Long>