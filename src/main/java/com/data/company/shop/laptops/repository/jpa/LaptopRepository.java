package com.data.company.shop.laptops.repository.jpa;

import com.data.company.shop.laptops.repository.entity.LaptopEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<LaptopEntity, UUID> {

}
