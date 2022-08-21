package com.data.company.shop.orders.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {

	ORDERED("ORDERED"),
	COMPLETED("COMPLETED");

	private final String status;

	Status(String status) {
		this.status = status;
	}

	@JsonValue
	public String getStatus() {
		return status;
	}
}
