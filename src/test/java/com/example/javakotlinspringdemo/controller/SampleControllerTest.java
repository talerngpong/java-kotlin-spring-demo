package com.example.javakotlinspringdemo.controller;

import com.example.javakotlinspringdemo.configuration.SampleConfiguration;
import com.example.javakotlinspringdemo.service.SampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

    private static final String SAMPLE_URL = "/api/v1/test/";

    @MockBean
    private SampleService sampleService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldReturnSampleListSuccessfully_withRightPathValue() throws Exception {
        SampleConfiguration.KeyValuePair pair = new SampleConfiguration.KeyValuePair();
        pair.setKey("testKey");
        pair.setValue("testValue");

        List<SampleConfiguration.KeyValuePair> list = new ArrayList<>();
        list.add(pair);

        when(sampleService.getSampleList()).thenReturn(list);

        mvc.perform(get(SAMPLE_URL + "right-path-value")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.returnedListKey", is(notNullValue())))
                .andExpect(jsonPath("$.returnedListKey[0].key", is("testKey")))
                .andExpect(jsonPath("$.returnedListKey[0].value", is("testValue")));

        verify(sampleService).getSampleList();
    }

    @Test
    public void shouldReturnSampleListSuccessfully_withOtherPathValue() throws Exception {
        SampleConfiguration.KeyValuePair pair = new SampleConfiguration.KeyValuePair();
        pair.setKey("testKey");
        pair.setValue("testValue");

        List<SampleConfiguration.KeyValuePair> list = new ArrayList<>();
        list.add(pair);

        when(sampleService.getSampleList()).thenReturn(list);

        mvc.perform(get(SAMPLE_URL + "other-path-value")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().string("{}"));


    }
}