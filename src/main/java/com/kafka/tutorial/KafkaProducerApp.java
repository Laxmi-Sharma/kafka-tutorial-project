package com.kafka.tutorial;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * Hello world!
 *
 */
public class KafkaProducerApp {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "BROKER-1:9892, BROKER-2:9093");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		ProducerRecord myMessage = new ProducerRecord("my_topic","My message 1");
		KafkaProducer myProducer = new KafkaProducer(props);
	}
}
