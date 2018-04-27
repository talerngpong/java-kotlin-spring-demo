package com.example.javakotlinspringdemo.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "sample-conf")
class SampleConfiguration {

    var title: String? = null
    var sampleList: List<KeyValuePair>? = null

    class KeyValuePair {

        var key: String? = null
        var value: String? = null
    }

}
