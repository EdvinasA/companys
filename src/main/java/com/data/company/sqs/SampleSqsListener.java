package com.data.company.sqs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SampleSqsListener {

  @SqsListener(value = "sample-queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
  public void handle(String message) {
    log.info("Message = {}", message);
  }
}
