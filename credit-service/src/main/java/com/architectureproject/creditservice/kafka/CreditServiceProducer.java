package com.architectureproject.creditservice.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CreditServiceProducer {

    private KafkaTemplate<String,String> kafkaTemplate;

    public CreditServiceProducer(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }

    public void sendMessage(String topicName,String message){
        this.kafkaTemplate.send(topicName,message);
    }


}
