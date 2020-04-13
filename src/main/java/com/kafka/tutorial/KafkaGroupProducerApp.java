package com.kafka.tutorial;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaGroupProducerApp {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092, localhost:9093");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		KafkaProducer<String, String> myProducer= new KafkaProducer<String, String>(props);
		try {
			int counter = 0;
			while(counter<100){
				myProducer.send(new ProducerRecord<String, String>("my-big-topic", "qpwoeiruytalskjdfhgmzxnbcv"));
				counter++;
			}
		} catch (Exception e) {
			e.getMessage();
		}finally {
			myProducer.close();
		}
	}

}
