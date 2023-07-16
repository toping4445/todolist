package com.kakaopaycorp.todolist.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Service
import org.thymeleaf.context.Context

@Service
class OozieWorkflowGenerator {

    @Autowired
    lateinit var resourceLoader: ResourceLoader

    fun generateWorkflowXml(db: String, table: String, importType: String, impalaStatType: String): String {
        val context = Context()
        context.setVariable("db", db)
        context.setVariable("table", table)
        context.setVariable("importType", importType)
        context.setVariable("impalaStatType", impalaStatType)

        val wfStartTemplate = loadTemplate("classpath:oozie/workflow/wf_start.txt")
        val wfCreateStagingTableTemplate = loadTemplate("classpath:oozie/workflow/wf_create_staging_table.txt")
        val wfKillEndTemplate = loadTemplate("classpath:oozie/workflow/wf_kill_end.txt")

        val workflowXmlBuilder = StringBuilder()
        workflowXmlBuilder.append(populateTemplate(wfStartTemplate, context))
        workflowXmlBuilder.append(populateTemplate(wfCreateStagingTableTemplate, context))
        workflowXmlBuilder.append(populateTemplate(wfKillEndTemplate, context))

        return workflowXmlBuilder.toString()
    }

    private fun loadTemplate(templatePath: String): String {
        val resource = resourceLoader.getResource(templatePath)
        return resource.inputStream.bufferedReader().use { it.readText() }
    }

    private fun populateTemplate(template: String, context: Context): String {
        var populatedTemplate = template
        context.variableNames.forEach { variableName ->
            val variableValue = context.getVariable(variableName)?.toString()
            populatedTemplate = populatedTemplate.replace("\${$variableName}", variableValue ?: "")
        }
        return populatedTemplate
    }
}
