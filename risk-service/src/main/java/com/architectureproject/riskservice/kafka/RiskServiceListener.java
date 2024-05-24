package com.architectureproject.riskservice.kafka;

import com.architectureproject.riskservice.config.Topics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RiskServiceListener {


    private RiskServiceProducer producer;


    private static final Logger LOGGER = LoggerFactory.getLogger(RiskServiceListener.class);

    public RiskServiceListener(RiskServiceProducer producer) {
        this.producer = producer;
    }

    // The result of the commercial service processing
    @KafkaListener(topics = "risk-process", groupId = "risk-service")
    public void consumeFromRiskQueue(String data){
        LOGGER.info("Checking for local debt ratio...");
        LOGGER.info("Local debt ratio is sufficient...");
        LOGGER.info("Checking for other banks debt through the central bank...");
        LOGGER.info("Data from central bank came...");
        LOGGER.info("Checking for document integrity");

        producer.sendMessage(Topics.OcrExtractJob,"For OCR to check documents");
    }



    // The result of the OCR processing
    @KafkaListener(topics = Topics.OcrExtractResult, groupId = "risk-service")
    public void consumeFromOCRQueue(String data){
        LOGGER.info("Result received from the OCR with success...");
        LOGGER.info("The final score is attributed with 99/100");
        LOGGER.info("Great Score !!");
        LOGGER.info("Going forward to the next step.");
        producer.sendMessage("agreement-process","For Credit Service");
    }
}
