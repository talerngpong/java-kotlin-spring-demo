package com.example.javakotlinspringdemo.controller

import com.example.javakotlinspringdemo.service.SampleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class SampleController(private val sampleService: SampleService) {

    @GetMapping("/test/{samplePathVariable}")
    fun getSampleList(@PathVariable samplePathVariable: String): Map<String, Any> {
        return if ("right-path-value" == samplePathVariable) {
            val returnedBody = HashMap<String, Any>()
            returnedBody.put("returnedListKey", sampleService.sampleList)

            returnedBody
        } else {
            HashMap()
        }
    }

}
