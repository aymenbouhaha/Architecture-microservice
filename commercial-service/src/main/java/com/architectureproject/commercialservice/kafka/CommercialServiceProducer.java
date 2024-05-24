package com.architectureproject.commercialservice.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CommercialServiceProducer {

    private KafkaTemplate<String,String> kafkaTemplate;

    public CommercialServiceProducer(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }

    public void sendMessage(String topicName,String message){
        this.kafkaTemplate.send(topicName,message);
    }


}
