package com.data.company.shop.viewedItems.validators;

import com.data.company.shop.viewedItems.model.ViewedItem;
import com.data.company.shop.viewedItems.repository.ViewedItemQueryRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ViewedItemValidator {

	private final ViewedItemQueryRepository queryRepository;

	public boolean validate(ViewedItem item) {
		Optional<ViewedItem> optionalItem = queryRepository.findViewedItem(item.getItemId(), item.getUserId());

		return optionalItem.isPresent();
	}
}
