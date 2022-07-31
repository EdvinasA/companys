package com.data.company.shop.laptops.repository;

import com.data.company.shop.laptops.model.Laptop;
import com.data.company.shop.laptops.repository.converter.LaptopConverter;
import com.data.company.shop.laptops.repository.jpa.LaptopRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class LaptopQueryRepository {

  private final LaptopConverter converter;
  private final LaptopRepository jpaRepository;

  public Page<Laptop> findAll(Pageable pageable) {
    return jpaRepository.findAll(pageable)
        .map(converter::convertFromEntity);
  }

  public Laptop findById(UUID id) throws NotFoundException {
    return jpaRepository.findById(id)
        .map(converter::convertFromEntity)
        .orElseThrow(NotFoundException::new);
  }

  public List<Laptop> findAll() {
    return jpaRepository.findAll()
        .stream()
        .map(converter::convertFromEntity)
        .collect(Collectors.toList());
  }
}
