package com.data.company.sqs.messaging;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class SqsMessagingService implements MessagingService {

	//	private final AmazonSQS sqsClient;

	@Override
	public void sendMessage(String message) {
		//    log.info("Sending: {}", message);
		//    SendMessageRequest messageRequest = new SendMessageRequest()
		//        .withQueueUrl(sqsClient.getQueueUrl("sample-queue").getQueueUrl())
		//        .withMessageBody(JsonUtils.toJson(message))
		//        .withDelaySeconds(0);
		//
		//    sqsClient.sendMessage(messageRequest);
	}
}
