package com.kakaopaycorp.todolist

import com.kakaopaycorp.todolist.config.AppConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(AppConfig::class)
class TodolistApplication

fun main(args: Array<String>) {
	runApplication<TodolistApplication>(*args)
}
