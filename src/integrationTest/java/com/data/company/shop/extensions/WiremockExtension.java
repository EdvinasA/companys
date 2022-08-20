package com.data.company.shop.extensions;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class WiremockExtension extends WireMockServer implements BeforeEachCallback, AfterEachCallback {

	public WiremockExtension() {
		super(8888);
	}

	@Override
	public void afterEach(ExtensionContext context) {
		stop();
	}

	@Override
	public void beforeEach(ExtensionContext context) {
		start();
		resetAll();

		configureFor("localhost", 8888);
	}
}
