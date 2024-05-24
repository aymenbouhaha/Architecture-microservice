package com.architectureproject.ocrservice.kafka;

import com.architectureproject.ocrservice.config.Topics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OcrServiceListener {


    private OcrServiceProducer producer;


    private static final Logger LOGGER = LoggerFactory.getLogger(OcrServiceListener.class);

    public OcrServiceListener(OcrServiceProducer producer) {
        this.producer = producer;
    }


    @KafkaListener(topics = Topics.OcrExtractJob, groupId = "ocr-service")
    public void consume(String data){

        LOGGER.info("Checking documents integrity...");
        LOGGER.info("Extracting data in progress...");
        LOGGER.info("Data extracted successfully");
        LOGGER.info("User is totally eligible");
        producer.sendMessage(Topics.OcrExtractResult,"final result for risk service");
    }




}
