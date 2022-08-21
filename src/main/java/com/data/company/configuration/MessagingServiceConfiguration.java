package com.data.company.configuration;

import com.amazonaws.services.sqs.AmazonSQS;
import com.data.company.sqs.messaging.MessagingService;
import com.data.company.sqs.messaging.SqsMessagingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingServiceConfiguration {

//	@Bean
//	MessagingService messagingService(AmazonSQS amazonSQS) {
//		return new SqsMessagingService(amazonSQS);
//	}
}
