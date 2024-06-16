package com.example.monitoringProject.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;
    private final SimpMessagingTemplate template;

    @Autowired
    public RedisService(RedisTemplate<String, String> redisTemplate, SimpMessagingTemplate template) {
        this.redisTemplate = redisTemplate;
        this.template = template;
    }

    public void saveMessage(String key, String message) {
        redisTemplate.opsForValue().set(key, message);
        template.convertAndSend("/topic/redis", message);
    }

    public String getMessage(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}

