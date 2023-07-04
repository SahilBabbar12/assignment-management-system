package com.example.gcpcloudfunction;


import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

@SpringBootApplication
public class GcpCloudFunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GcpCloudFunctionApplication.class, args);
	}
	@Value("${google.application.project-id}")
	String projectId;
	@Value("${google.application.subscriptionId}")
	String subscriptionId;
	@Bean
	public Consumer<PubsubMessage> pubSubFunction() {
		ProjectSubscriptionName subscriptionName =
				ProjectSubscriptionName.of(projectId, subscriptionId);

		MessageReceiver receiver =
				(PubsubMessage message, AckReplyConsumer consumer) -> {
					System.out.println("Id: " + message.getMessageId());
					System.out.println("Data: " + message.getData().toStringUtf8());
				};

		Subscriber subscriber = null;
		try {
			subscriber = Subscriber.newBuilder(subscriptionName, receiver).build();
			subscriber.startAsync().awaitRunning();
			System.out.printf("Listening for messages on %s:\n", subscriptionName.toString());
			subscriber.awaitTerminated(30, TimeUnit.SECONDS);
		} catch (TimeoutException timeoutException) {
			subscriber.stopAsync();
		}
		return pubsubMessage -> System.out.println("The Pub/Sub message data: " + pubsubMessage.getData());
	}
}
