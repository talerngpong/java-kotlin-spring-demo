package com.example.javakotlinspringdemo.service;

import com.example.javakotlinspringdemo.configuration.SampleConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {

    private SampleConfiguration sampleConfiguration;

    public SampleService(SampleConfiguration sampleConfiguration) {
        this.sampleConfiguration = sampleConfiguration;
    }

    public List<SampleConfiguration.KeyValuePair> getSampleList() {
        return sampleConfiguration.getSampleList();
    }

}
