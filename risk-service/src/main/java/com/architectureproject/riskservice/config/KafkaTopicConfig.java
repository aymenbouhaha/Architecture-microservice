package com.architectureproject.riskservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;



@Configuration
public class KafkaTopicConfig {


    @Bean
    public NewTopic ocrExtractJobTopic(){
        return TopicBuilder.name(Topics.OcrExtractJob).build();
    }

    @Bean
    public NewTopic agreementProcessTopic(){
        return TopicBuilder.name(Topics.AgreementProcess).build();
    }

}
