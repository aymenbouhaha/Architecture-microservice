package com.architectureproject.riskservice.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RiskServiceProducer {

    private KafkaTemplate<String,String> kafkaTemplate;

    public RiskServiceProducer(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }

    public void sendMessage(String topicName,String message){
        this.kafkaTemplate.send(topicName,message);
    }


}
