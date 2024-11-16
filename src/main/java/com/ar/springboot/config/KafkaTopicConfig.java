package com.ar.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic.json-name}")
    private String topicName_Json;

    @Bean
    public NewTopic arTopic() {
        return TopicBuilder.name(topicName)
                // .partitions(10) ==> if need create partition, but here using defult partition
                //provided by kafka.
                .build();
    }

    @Bean
    public NewTopic jsonArTopic() {
        return TopicBuilder.name(topicName_Json)
                .build();
    }
}
