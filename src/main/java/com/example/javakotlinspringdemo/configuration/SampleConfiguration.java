package com.example.javakotlinspringdemo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "sample-conf")
public class SampleConfiguration {

    private String title;
    private List<KeyValuePair> sampleList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<KeyValuePair> getSampleList() {
        return sampleList;
    }

    public void setSampleList(List<KeyValuePair> sampleList) {
        this.sampleList = sampleList;
    }

    public static class KeyValuePair {

        private String key;
        private String value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}
