package com.kakaopaycorp.todolist.service


import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class OozieWorkflowGeneratorTest {

    @Autowired
    lateinit var generator: OozieWorkflowGenerator

    @Test
    fun generateWorkflowXml() {
        // 테스트할 데이터 설정
        val db = "my_db"
        val table = "my_table"
        val importType = "full"
        val impalaStatType = "incremental"

        // generateWorkflowXml 메소드 호출
        val resultXml = generator.generateWorkflowXml(db, table, importType, impalaStatType)
        assertTrue(resultXml.isNotEmpty())
        println(resultXml)

    }
}