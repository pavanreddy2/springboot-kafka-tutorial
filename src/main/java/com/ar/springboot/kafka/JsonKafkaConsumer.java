package com.ar.springboot.kafka;

import com.ar.springboot.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    @Value("${spring.kafka.topic.json-name}")
    private String topicName;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.json-name}", groupId = "myGroup")
    public void consumer(User data){
        LOGGER.info(String.format("Message received Successfully %s", data.toString()));

    }
}
