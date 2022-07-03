package com.data.company.shop.service;

import com.data.company.shop.model.Categories;
import com.data.company.shop.shared.Category;
import com.data.company.shop.shared.ComputerAndOfficeCategory;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShopQueryService {

  public Categories getCategories() {
    List<String> categories = Stream.of(Category.values())
        .map(Enum::name)
        .collect(Collectors.toList());

    Categories object = new Categories();
    object.setMainCategories(categories);

    return object;
  }
}
