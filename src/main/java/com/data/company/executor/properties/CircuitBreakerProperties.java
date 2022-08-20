package com.data.company.executor.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CircuitBreakerProperties {

	private int failureRateThreshold;
	private int secondsInOpenState;
	private int permittedNumberOfCallsInHalfOpenState;
	private int slidingWindowSize;

}
