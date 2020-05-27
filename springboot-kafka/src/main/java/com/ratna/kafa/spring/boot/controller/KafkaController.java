package com.ratna.kafa.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ratna.kafa.spring.boot.dto.Employee;
import com.ratna.kafa.spring.boot.service.KafkaSenderService;

@RestController
public class KafkaController {

	@Autowired
	KafkaSenderService kafkaSenderService;

	@GetMapping("/kafka/produce")
	public String producer(@RequestParam String message) {
		kafkaSenderService.send(message);
		return "Message sent to the kafka Topic ratna_topic_one successfully";
	}

	@PostMapping("/kafka/produce")
	public String producer(@RequestBody Employee emp) {
		kafkaSenderService.send(emp);
		return "Message sent to the kafka Topic ratna_topic_two successfully";
	}

}
