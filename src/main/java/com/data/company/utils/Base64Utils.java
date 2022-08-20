package com.data.company.utils;

import java.util.Base64;
import java.util.Base64.Encoder;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Base64Utils {

	private static final Encoder ENCODER = Base64.getEncoder();

	public static String encodeToString(byte[] bytes) {
		return ENCODER.encodeToString(bytes);
	}

	public static String encodeToString(String value) {
		return ENCODER.encodeToString(value.getBytes());
	}
}
