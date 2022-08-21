package com.data.company.shop.orders.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentMethod {

	BANK_CITADELE("BANK_CITADELE"),
	BANK_LUMINOR("BANK_LUMINOR"),
	BANK_REVOLUT("BANK_REVOLUT"),
	BANK_SEB("BANK_SEB"),
	BANK_SWEDBANK("BANK_SWEDBANK"),
	PAYMENT_CARD_KLIX("PAYMENT_CARD_KLIX"),
	PAY_3("PAY_3"),
	PAY_ON_WITHDRAWAL("PAY_ON_WITHDRAWAL");

	private final String method;

	PaymentMethod(String status) {
		this.method = status;
	}

	@JsonValue
	public String getStatus() {
		return method;
	}
}
