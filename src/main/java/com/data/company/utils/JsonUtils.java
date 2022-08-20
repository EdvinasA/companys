package com.data.company.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonUtils {

	private static final ObjectMapper MAPPER;

	static {
		MAPPER = createMapper();
	}

	public static String toJson(Object value) {
		return toJson(value, false);
	}

	public static String toJson(Object value, boolean pretty) {
		ObjectMapper mapper = MAPPER;

		if (pretty) {
			mapper = createMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			mapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
		}

		try {
			return mapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			throw new IllegalArgumentException("Error");
		}
	}

	public static <T> T toObject(Reader reader, Class<T> clazz) {
		try (Reader reader1 = reader) {
			return MAPPER.readValue(reader1, clazz);
		} catch (IOException e) {
			throw new IllegalArgumentException();
		}
	}

	public static ObjectMapper createMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		JavaTimeModule timeModule = buildJavaTimeModule();

		objectMapper.registerModule(timeModule);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

		return objectMapper;
	}

	private static JavaTimeModule buildJavaTimeModule() {
		JavaTimeModule timeModule = new JavaTimeModule();

		timeModule
				.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ISO_LOCAL_DATE));
		timeModule.addSerializer(LocalDateTime.class,
				new LocalDateTimeSerializer(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

		return timeModule;
	}
}
