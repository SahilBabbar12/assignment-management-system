package com.knoldus.assignment_management_system.service.serviceimpl;


import com.google.api.core.ApiFuture;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.threeten.bp.Duration;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

    @Slf4j
    @Service
    public class AssignmentPublisher {
        private AssignmentPublisher() {

        }
        public static void publishAssignment(String projectId, String topicId, String message)
                throws IOException, ExecutionException, InterruptedException {
            TopicName topicName = TopicName.of(projectId, topicId);

            Publisher publisher = null;
            Duration initialRetryDelay = Duration.ofMillis(100);
            double retryDelayMultiplier = 2.0;
            Duration maxRetryDelay = Duration.ofSeconds(60);
            Duration initialRpcTimeout = Duration.ofSeconds(1);
            double rpcTimeoutMultiplier = 1.0;
            Duration maxRpcTimeout = Duration.ofSeconds(600);
            Duration totalTimeout = Duration.ofSeconds(600);
            RetrySettings retrySettings =
                    RetrySettings.newBuilder().setInitialRetryDelay(initialRetryDelay)
                            .setRetryDelayMultiplier(retryDelayMultiplier).setMaxRetryDelay(maxRetryDelay)
                            .setInitialRpcTimeout(initialRpcTimeout).setRpcTimeoutMultiplier(rpcTimeoutMultiplier)
                            .setMaxRpcTimeout(maxRpcTimeout).setTotalTimeout(totalTimeout)
                            .build();
            publisher = Publisher.newBuilder(topicName).setRetrySettings(retrySettings).build();
            try {
            ByteString data = ByteString.copyFromUtf8(message);
            PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();
            ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
            String messageId = messageIdFuture.get();
            log.info("Published message ID: " + messageId);

            } finally {
                if (publisher != null) {
                    publisher.shutdown();
                    publisher.awaitTermination(1, TimeUnit.MINUTES);
                }
            }
        }

    }
