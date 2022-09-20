package com.data.company.shop.products.repository;

import com.data.company.shop.products.model.Product;
import com.data.company.shop.products.predicate.ProductPredicateBuilder;
import com.data.company.shop.products.queries.ProductSearchQuery;
import com.data.company.shop.products.repository.converter.ProductConverter;
import com.data.company.shop.products.repository.jpa.ProductJpaRepository;
import com.querydsl.core.types.Predicate;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ProductQueryRepository {

	private final ProductJpaRepository jpaRepository;
	private final ProductConverter converter;
	private final ProductPredicateBuilder predicateBuilder;

	public Page<Product> findAll(Pageable pageable, ProductSearchQuery query) {
		Predicate searchPredicate = predicateBuilder.buildPredicate(query);
		return jpaRepository.findAll(searchPredicate, pageable)
				.map(converter::convertFromEntity);
	}

	public Optional<Product> findById(UUID id) {
		return jpaRepository.findById(id)
				.map(converter::convertFromEntity);
	}

}
