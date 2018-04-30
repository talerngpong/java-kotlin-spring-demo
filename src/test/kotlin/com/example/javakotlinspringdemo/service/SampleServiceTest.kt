package com.example.javakotlinspringdemo.service

import com.example.javakotlinspringdemo.configuration.SampleConfiguration
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SampleServiceTest {

    @Mock
    private var sampleConfiguration: SampleConfiguration? = null

    private var sampleService: SampleService? = null

    @Before
    fun setUp() {
        sampleService = SampleService(sampleConfiguration)
    }

    @Test
    fun shouldReturnSampleListSuccessfully() {
        val pair = SampleConfiguration.KeyValuePair()
        pair.key = "testKey"
        pair.value = "testValue"

        val list = ArrayList<SampleConfiguration.KeyValuePair>()
        list.add(pair)

        Mockito.`when`(sampleConfiguration!!.sampleList).thenReturn(list)

        val returnedList = sampleService!!.sampleList

        Assertions.assertThat(returnedList).isNotNull
        Assertions.assertThat(returnedList).isNotEmpty
        Assertions.assertThat(returnedList[0]).isNotNull
        Assertions.assertThat(returnedList[0].key).isNotNull()
        Assertions.assertThat(returnedList[0].key).isEqualTo("testKey")
        Assertions.assertThat(returnedList[0].value).isNotNull()
        Assertions.assertThat(returnedList[0].value).isEqualTo("testValue")
    }
}