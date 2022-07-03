package com.data.company.shop.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import org.springframework.core.io.Resource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class TestFileUtils {

  @Autowired
  private final ObjectMapper objectMapper;

  public String readResourceAsString(Resource resource) {
    try(InputStream in = resource.getInputStream()) {
      JsonNode jsonNode = objectMapper.readValue(in, JsonNode.class);

      return objectMapper.writeValueAsString(jsonNode);
    } catch (Exception ex) {
      log.error("Failed to read resource as string: {}", ex.getMessage());
      throw new RuntimeException(ex);
    }
  }
}
