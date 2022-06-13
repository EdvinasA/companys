package com.data.company.shop.products.service;

import com.data.company.shop.products.model.Product;
import com.data.company.shop.products.repository.ProductCommandRepository;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class ProductCommandServiceTest {

  @Mock
  ProductCommandRepository commandRepository;

  @InjectMocks
  ProductCommandService commandService;

  @Captor
  ArgumentCaptor<Product> productCaptor;

  @Test
  void shouldPersistAndCreateProduct() {
    commandService.createNewProduct(buildProduct());

    Mockito.verify(commandRepository).create(productCaptor.capture());
    Product product = productCaptor.getValue();

    assertNotNull(product);
  }

  private Product buildProduct() {
    Product product = new Product();
    product.setId(UUID.fromString("715d1690-fbb9-4b0c-a5f7-9395b8276ed3"));
    return product;
  }
}
