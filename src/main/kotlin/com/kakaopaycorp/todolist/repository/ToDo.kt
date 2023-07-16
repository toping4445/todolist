package com.kakaopaycorp.todolist.repository

import org.hibernate.annotations.ColumnDefault
import javax.persistence.*

@Entity
class ToDo(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(nullable = false)
        @ColumnDefault("false")
        var completed: Boolean = false,

        @Column(nullable = false)
        var toDoName: String
)