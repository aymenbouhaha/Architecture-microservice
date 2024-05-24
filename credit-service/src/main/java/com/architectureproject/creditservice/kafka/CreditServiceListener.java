package com.architectureproject.creditservice.kafka;

import com.architectureproject.creditservice.config.Topics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CreditServiceListener {


    private CreditServiceProducer producer;


    private static final Logger LOGGER = LoggerFactory.getLogger(CreditServiceListener.class);

    public CreditServiceListener(CreditServiceProducer producer) {
        this.producer = producer;
    }

    @KafkaListener(topics = Topics.AgreementProcess, groupId = "credit-service")
    public void consume(String data){
        LOGGER.info("Received documents");
        LOGGER.info("Storing document to the file system please wait ...");
        LOGGER.info("Document stored successfully");
        LOGGER.info("Generating the contract ...");
        LOGGER.info("Contract generated");
        producer.sendMessage(Topics.AgreementResult,"Successfully generated contract, we are happy you became one of our clients");
    }



}
