//package com.knoldus.assignment_management_system.service.serviceimpl;
//
//import com.google.api.core.ApiFuture;
//import com.google.cloud.pubsub.v1.Publisher;
//import com.google.protobuf.ByteString;
//import com.google.pubsub.v1.PubsubMessage;
//import com.google.pubsub.v1.TopicName;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.*;
//import static org.mockito.Mockito.*;
//
//import java.io.IOException;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.TimeUnit;
//
//public class AssignmentPublisherImplTest {
//
//    @Mock
//    private Publisher.Builder publisherBuilder;
//    @Mock
//    private Publisher publisherMock;
//
//    @Mock
//    private ApiFuture<String> messageIdFutureMock;
//
//    @Captor
//    private ArgumentCaptor<PubsubMessage> pubsubMessageCaptor;
//
//    private AssignmentPublisher assignmentPublisher;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//        assignmentPublisher = new AssignmentPublisher();
//    }
//
//    @Test
//    public void testPublishAssignment() throws IOException, ExecutionException, InterruptedException {
//        String projectId = "nodal-descent-389716";
//        String topicId = "pub-sub-Topic";
//        String message = "Test message";
//        String messageId = "messageId";
//
//        TopicName topicNameMock = mock(TopicName.class);
//        PubsubMessage pubsubMessageMock = mock(PubsubMessage.class);
//
////        when(publisherBuilder.build()).thenReturn(publisherMock);
////        when(topicNameMock.of(projectId, topicId)).thenReturn(topicNameMock);
////        when(pubsubMessageMock.getData()).thenReturn(ByteString.copyFromUtf8(message));
//        when(publisherMock.publish(pubsubMessageMock)).thenReturn(messageIdFutureMock);
//        when(messageIdFutureMock.get()).thenReturn(messageId);
//
//        AssignmentPublisher.publishAssignment(projectId, topicId, message);
//
//        verify(publisherBuilder).build();
//        verify(topicNameMock).of(projectId, topicId);
//        verify(publisherMock).publish(pubsubMessageCaptor.capture());
//        verify(messageIdFutureMock).get();
//        verify(publisherMock).shutdown();
//        verify(publisherMock).awaitTermination(1, TimeUnit.MINUTES);
//        verifyNoMoreInteractions(publisherBuilder, publisherMock, topicNameMock, messageIdFutureMock);
//
//        PubsubMessage capturedPubsubMessage = pubsubMessageCaptor.getValue();
//        ByteString capturedData = capturedPubsubMessage.getData();
//        String capturedMessage = capturedData.toStringUtf8();
//
//        Assertions.assertEquals(message, capturedMessage);
//    }
//}
