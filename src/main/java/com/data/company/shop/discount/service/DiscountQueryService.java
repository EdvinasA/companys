package com.data.company.shop.discount.service;

import com.data.company.shop.discount.model.Discount;
import com.data.company.shop.discount.model.DiscountResponse;
import com.data.company.shop.discount.repository.DiscountQueryRepository;
import com.data.company.shop.discount.repository.DiscountedItemQueryRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DiscountQueryService {

  private final DiscountQueryRepository queryRepository;
  private final DiscountedItemQueryRepository discountedItemQueryRepository;

  public DiscountResponse checkDiscount(String code) {
    Optional<Discount> storedDiscount = queryRepository.findDiscountByCode(code);
    if (storedDiscount.isPresent() &&
        storedDiscount.get().getValidUntil().isBefore(LocalDate.now())) {
      return new DiscountResponse()
          .setExpired(false)
          .setPercent(storedDiscount.get().getPercent())
          .setCode(code)
          .setItems(
              discountedItemQueryRepository
                  .findAllDiscountedItemsByDiscountId(storedDiscount.get().getId())
          )
          .setForAllItems(storedDiscount.get().isForAllItems());
    }

    return new DiscountResponse()
        .setExpired(true)
        .setCode(code);
  }
}
