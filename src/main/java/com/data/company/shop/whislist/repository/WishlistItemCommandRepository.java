package com.data.company.shop.whislist.repository;

import com.data.company.shop.whislist.model.WishlistItem;
import com.data.company.shop.whislist.repository.converter.WishlistItemConverter;
import com.data.company.shop.whislist.repository.entity.WishlistItemEntity;
import com.data.company.shop.whislist.repository.jpa.WishlistItemJpaRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class WishlistItemCommandRepository {

	private final WishlistItemJpaRepository jpaRepository;
	private final WishlistItemConverter converter;

	@Transactional
	public void create(WishlistItem input) {
		WishlistItemEntity entity = converter.convertToEntity(input);

		jpaRepository.save(entity);
	}

	@Transactional
	public void deleteAllByProfileId(List<WishlistItem> input) {
		List<WishlistItemEntity> entities = input.stream()
				.map(converter::convertToEntity)
				.collect(Collectors.toList());

		jpaRepository.deleteAll(entities);
	}

	@Transactional
	public void delete(UUID itemId) {
		jpaRepository.deleteById(itemId);
	}
}
