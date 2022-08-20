package com.data.company.shop.viewedItems.service;

import com.data.company.shop.viewedItems.model.ViewedItem;
import com.data.company.shop.viewedItems.repository.ViewedItemQueryRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ViewedItemQueryService {

	private final ViewedItemQueryRepository queryRepository;

	public List<ViewedItem> getViewedItemsByUserId(UUID userId) {
		return queryRepository.getListOfViewedItems(userId);
	}
}
