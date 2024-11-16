package com.ar.springboot.kafka;

import com.ar.springboot.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    @Value("${spring.kafka.topic.json-name}")
    private String topicName;

    private KafkaTemplate kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage (User data){
        LOGGER.info(String.format("Message Sent %s", data.toString()));
        Message<User> message = MessageBuilder.withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .build();
        kafkaTemplate.send(message);
    }
}
