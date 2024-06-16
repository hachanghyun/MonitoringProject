package com.example.monitoringProject.controller;

import com.example.monitoringProject.kafka.KafkaProducer;
import com.example.monitoringProject.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeleafController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private RedisService redisService;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/sendKafkaMessage")
    public String sendKafkaMessage(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return "redirect:/";
    }

    @PostMapping("/saveRedisMessage")
    public String saveRedisMessage(@RequestParam("key") String key, @RequestParam("message") String message) {
        redisService.saveMessage(key, message);
        return "redirect:/";
    }
}

