package com.data.company.shop.viewedItems.service;

import com.data.company.shop.viewedItems.model.ViewedItem;
import com.data.company.shop.viewedItems.repository.ViewedItemCommandRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ViewedItemCommandService {

	private final ViewedItemCommandRepository commandRepository;

	public void saveViewedItem(ViewedItem input) {
		input.setId(UUID.randomUUID());

		commandRepository.create(input);
	}
}
