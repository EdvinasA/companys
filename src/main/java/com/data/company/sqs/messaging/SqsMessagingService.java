package com.data.company.sqs.messaging;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.data.company.utils.JsonUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SqsMessagingService implements MessagingService {

  private final AmazonSQS sqsClient;

  @Override
  public void sendMessage(String message) {
    SendMessageRequest messageRequest = new SendMessageRequest()
        .withQueueUrl(sqsClient.getQueueUrl("local-sample-queue").getQueueUrl())
        .withMessageBody(JsonUtils.toJson(message));

    sqsClient.sendMessage(messageRequest);
  }
}
