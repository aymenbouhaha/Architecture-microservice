package com.architectureproject.apigateway.kafka;

import com.architectureproject.apigateway.config.Topics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OcrServiceListener {




    private static final Logger LOGGER = LoggerFactory.getLogger(OcrServiceListener.class);



    @KafkaListener(topics = Topics.AgreementResult, groupId = "api-gateway")
    public void consume(String data){

        LOGGER.info(data);

    }




}
