package com.data.company.shop.orders.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DeliveryOption {

	TO_HOME("TO_HOME"),
	WITHDRAWAL("WITHDRAWAL"),
	DPD("DPD"),
	OMNIVA("OMNIVA"),
	LP_EXPRESS("LP_EXPRESS");

	private final String option;

	DeliveryOption(String status) {
		this.option = status;
	}

	@JsonValue
	public String getStatus() {
		return option;
	}
}
