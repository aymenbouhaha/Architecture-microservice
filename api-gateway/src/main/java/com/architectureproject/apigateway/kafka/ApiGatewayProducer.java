package com.architectureproject.apigateway.kafka;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ApiGatewayProducer {

    private KafkaTemplate<String,String> kafkaTemplate;

    public ApiGatewayProducer(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }

    public void sendMessage(String topicName,String message){
        this.kafkaTemplate.send(topicName,message);
    }

}
