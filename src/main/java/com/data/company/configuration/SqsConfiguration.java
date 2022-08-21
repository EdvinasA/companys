package com.data.company.configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import java.util.List;
import org.springframework.cloud.aws.messaging.config.QueueMessageHandlerFactory;
import org.springframework.cloud.aws.messaging.support.NotificationMessageArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

@Configuration
public class SqsConfiguration {

//	@Bean
//	@Primary
//	public AmazonSQSAsync localAmazonSQSAsync() {
//		return AmazonSQSAsyncClientBuilder
//				.standard()
//				//        .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("https://sqs.eu-west-1.amazonaws.com/875563562468/", "eu-west-1"))
//				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("AKIA4XW5HWXSMSW45TVM", "Sz0Xnh6YS9ohFR55YDU4Q69dS+M85x7e1+EbaOGy")))
//				.withRegion("eu-west-1")
//				.build();
//	}
//
//	@Bean
//	public QueueMessageHandlerFactory queueMessageHandlerFactory(MappingJackson2MessageConverter messageConverter) {
//		var factory = new QueueMessageHandlerFactory();
//		factory.setArgumentResolvers(List.of(new NotificationMessageArgumentResolver(messageConverter)));
//
//		return factory;
//	}
//
//	@Bean
//	protected MappingJackson2MessageConverter messageConverter() {
//		var converter = new MappingJackson2MessageConverter();
//		converter.setSerializedPayloadClass(String.class);
//		converter.setStrictContentTypeMatch(false);
//
//		return converter;
//	}

}
