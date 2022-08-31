package com.data.company.shop.products.predicate;

import com.data.company.shop.products.queries.ProductSearchQuery;
import com.data.company.shop.products.repository.entity.QProductEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class ProductPredicateBuilder {

	public Predicate buildPredicate(ProductSearchQuery query) {
		QProductEntity qEntityProductShorthand = QProductEntity.productEntity;

		BooleanBuilder builder = new BooleanBuilder();

		Optional.ofNullable(query.getSubCategory())
				.ifPresent(subCategory -> builder.and(qEntityProductShorthand.subCategory.in(subCategory)));

		return builder;
	}
}
