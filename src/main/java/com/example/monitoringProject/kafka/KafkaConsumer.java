package com.example.monitoringProject.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private final SimpMessagingTemplate template;

    @Autowired
    public KafkaConsumer(SimpMessagingTemplate template) {
        this.template = template;
    }

    @KafkaListener(topics = "example-topic", groupId = "group_id")
    public void consume(String message) {
        template.convertAndSend("/topic/kafka", message);
    }
}

