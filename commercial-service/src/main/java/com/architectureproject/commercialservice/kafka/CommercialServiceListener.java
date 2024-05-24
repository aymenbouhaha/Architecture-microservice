package com.architectureproject.commercialservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CommercialServiceListener {


    private CommercialServiceProducer producer;



    private static final Logger LOGGER = LoggerFactory.getLogger(CommercialServiceListener.class);

    public CommercialServiceListener(CommercialServiceProducer producer) {
        this.producer = producer;
    }

    @KafkaListener(topics = "application-process", groupId = "commercial-service")
    public void consume(String data){
        LOGGER.info("The application is being processed...");
        LOGGER.info("Checking for Eligibility...");
        LOGGER.info("A score is established right now...");
        LOGGER.info("Client Eligible, going forward to the next step...");
        producer.sendMessage("risk-process","Client Eligible with score 80/100");
    }
}
