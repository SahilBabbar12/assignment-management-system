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

/**
 * Service implementation for publishing
 * assignments to a Google Cloud Pub/Sub topic.
 */

@Slf4j
@Service
public final class AssignmentPublisher {

    /**
     * The initial retry delay in milliseconds.
     */
    private static final int INITIAL_RETRY_DELAY_MS = 100;

    /**
     * The maximum retry delay in seconds.
     */
    private static final int MAX_RETRY_DELAY_SEC = 60;

    /**
     * The initial RPC timeout in seconds.
     */
    private static final int INITIAL_RPC_TIMEOUT_SEC = 1;

    /**
     * The maximum RPC timeout in seconds.
     */
    private static final int MAX_RPC_TIMEOUT_SEC = 600;

    /**
     * The total timeout in seconds.
     */
    private static final int TOTAL_TIMEOUT_SEC = 600;

    private AssignmentPublisher() {
        // private constructor to prevent instantiation
    }


    /**
     * Publishes an assignment message to a Google Cloud Pub/Sub topic.
     *
     * @param projectId the project ID
     * @param topicId   the topic ID
     * @param message   the assignment message to be published
     * @throws IOException          if an I/O error occurs
     * @throws ExecutionException   if an execution error occurs
     * @throws InterruptedException if the current thread is interrupted
     */
    public static void publishAssignment(final String projectId,
                                         final String topicId,
                                         final String message)
            throws IOException, ExecutionException, InterruptedException {
        TopicName topicName = TopicName.of(projectId, topicId);

        Publisher publisher = null;
        Duration initialRetryDelay =
                Duration.ofMillis(INITIAL_RETRY_DELAY_MS);
        double retryDelayMultiplier = 2.0;
        Duration maxRetryDelay =
                Duration.ofSeconds(MAX_RETRY_DELAY_SEC);
        Duration initialRpcTimeout =
                Duration.ofSeconds(INITIAL_RPC_TIMEOUT_SEC);
        double rpcTimeoutMultiplier = 1.0;
        Duration maxRpcTimeout =
                Duration.ofSeconds(MAX_RPC_TIMEOUT_SEC);
        Duration totalTimeout =
                Duration.ofSeconds(TOTAL_TIMEOUT_SEC);
        RetrySettings retrySettings =
                RetrySettings.newBuilder()
                        .setInitialRetryDelay(initialRetryDelay)
                        .setRetryDelayMultiplier(retryDelayMultiplier)
                        .setMaxRetryDelay(maxRetryDelay)
                        .setInitialRpcTimeout(initialRpcTimeout)
                        .setRpcTimeoutMultiplier(rpcTimeoutMultiplier)
                        .setMaxRpcTimeout(maxRpcTimeout)
                        .setTotalTimeout(totalTimeout)
                        .build();
        publisher = Publisher.newBuilder(topicName)
                .setRetrySettings(retrySettings)
                .build();
        try {
            ByteString data = ByteString.copyFromUtf8(message);
            PubsubMessage pubsubMessage = PubsubMessage
                    .newBuilder()
                    .setData(data)
                    .build();
            ApiFuture<String> messageIdFuture = publisher
                    .publish(pubsubMessage);
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
