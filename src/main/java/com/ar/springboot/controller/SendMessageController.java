package com.ar.springboot.controller;

import com.ar.springboot.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SendMessageController {

    public KafkaProducer kafkaProducer;

    public SendMessageController (KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

    //http://localhost:8080/api/sendMessage
    @GetMapping("/sendMessage")
    public ResponseEntity<String> publish(@RequestParam("message") String sendMessage){
        kafkaProducer.sendMessage(sendMessage);
        return ResponseEntity.ok("Message sent to the Topic");
    }
}

