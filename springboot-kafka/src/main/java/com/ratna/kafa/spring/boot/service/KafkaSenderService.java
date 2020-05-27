package com.ratna.kafa.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.ratna.kafa.spring.boot.dto.Employee;

@Service
public class KafkaSenderService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	private Gson gson;

	String kafkaTopic = "ratna_topic_one";
	String kafkaTopic1 = "ratna_topic_two";

	public void send(String message) {
		kafkaTemplate.send(kafkaTopic, message);
	}

	public void send(Employee employee) {
		kafkaTemplate.send(kafkaTopic1, gson.toJson(employee));
	}
}
