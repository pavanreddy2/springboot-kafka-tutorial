package com.ar.springboot.controller;

import com.ar.springboot.kafka.JsonKafkaProducer;
import com.ar.springboot.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
    private JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer){
        this.jsonKafkaProducer=jsonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> messageSent(@RequestBody User user){
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Message Sent Successfully..");
    }
}
