package com.data.company.sqs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;

@Slf4j
public class SampleSqsListener {

  @SqsListener(value = "${sqs.queues.local-sample-queue}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
  public void handle(String message) {
    log.info("Message = {}", message);
  }
}
