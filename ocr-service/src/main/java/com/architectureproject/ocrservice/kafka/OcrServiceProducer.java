package com.architectureproject.ocrservice.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OcrServiceProducer {

    private KafkaTemplate<String,String> kafkaTemplate;

    public OcrServiceProducer(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }

    public void sendMessage(String topicName,String message){
        this.kafkaTemplate.send(topicName,message);
    }


}
