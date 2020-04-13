package com.kafka.tutorial;

import java.util.ArrayList;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

public class KafkaConsumerAssignApp {
public static void main(String[] args) {
	Properties properties =new Properties();
	properties.put("bootstrap.servers", "localhost:9092,localhost:9093");
	properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	KafkaConsumer myConsumer = new KafkaConsumer(properties);
	ArrayList<TopicPartition> partitions = new ArrayList<TopicPartition>();
	TopicPartition myTopicPartition0 = new TopicPartition("my-topic", 0);
	TopicPartition myOtherTopicPartition2 = new TopicPartition("my-other-topic", 2);
	partitions.add(myTopicPartition0);
	partitions.add(myOtherTopicPartition2);
	myConsumer.assign(partitions);
	try {
		while (true) {
			ConsumerRecords<String, String> records = myConsumer.poll(10);
			for (ConsumerRecord<String, String> record : records) {
				System.out.println(String.format("Topic: %s, Partition: %d, Offset: %d, Key: %s, Value: %s",
						record.topic(), record.partition(), record.offset(), record.key(), record.value()));
			}

		}
	}catch(Exception e){
		System.out.println(e.getMessage());
	} finally {
		// TODO: handle finally clause
	}
}
}
