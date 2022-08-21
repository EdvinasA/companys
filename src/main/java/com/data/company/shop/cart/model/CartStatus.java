package com.data.company.shop.cart.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CartStatus {

	FILLING("FILLING"),
	MOVED_TO_ORDER("MOVED_TO_ORDER");

	private final String status;

	CartStatus(String status) {
		this.status = status;
	}

	@JsonValue
	public String getStatus() {
		return status;
	}
}
