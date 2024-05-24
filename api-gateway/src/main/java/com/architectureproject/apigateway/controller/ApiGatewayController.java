package com.architectureproject.apigateway.controller;
import com.architectureproject.apigateway.config.Topics;
import com.architectureproject.apigateway.kafka.ApiGatewayProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiGatewayController {


    private ApiGatewayProducer apiGatewayProducer;

    public ApiGatewayController(ApiGatewayProducer apiGatewayProducer){
        this.apiGatewayProducer=apiGatewayProducer;
    }



    @PostMapping("/contract")
    public ResponseEntity<String> contract(@RequestBody String message){
        apiGatewayProducer.sendMessage(Topics.AppProcess,message);
        return ResponseEntity.ok("Your contract is being generateed");
    }

}
