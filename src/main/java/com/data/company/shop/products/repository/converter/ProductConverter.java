package com.data.company.shop.products.repository.converter;

import com.data.company.shop.products.model.Product;
import com.data.company.shop.products.repository.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

  public ProductEntity convertToEntity(Product product) {
    ProductEntity productEntity = new ProductEntity();
    productEntity.setId(product.getId());
    productEntity.setPicture(product.getPicture());
    productEntity.setName(product.getName());
    productEntity.setDescription(product.getDescription());
    productEntity.setQuantity(product.getQuantity());
    productEntity.setPrice(product.getPrice());
    productEntity.setCustomerEvaluation(product.getCustomerEvaluation());
    productEntity.setHasDiscount(product.isHasDiscount());
    productEntity.setSmallDescription(product.getSmallDescription());
    return productEntity;
  }

  public Product convertFromEntity(ProductEntity productEntity) {
    Product product = new Product();
    product.setId(productEntity.getId());
    product.setPicture(productEntity.getPicture());
    product.setName(productEntity.getName());
    product.setDescription(productEntity.getDescription());
    product.setQuantity(productEntity.getQuantity());
    product.setPrice(productEntity.getPrice());
    product.setCustomerEvaluation(productEntity.getCustomerEvaluation());
    product.setHasDiscount(productEntity.isHasDiscount());
    product.setSmallDescription(productEntity.getSmallDescription());
    return product;
  }
}
