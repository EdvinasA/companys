package com.data.company.shop.discount.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;

/**
 * QDiscountedItemEntity is a Querydsl query type for DiscountedItemEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDiscountedItemEntity extends EntityPathBase<DiscountedItemEntity> {

	private static final long serialVersionUID = -1350998790L;

	public static final QDiscountedItemEntity discountedItemEntity = new QDiscountedItemEntity("discountedItemEntity");

	public final ComparablePath<java.util.UUID> discountId = createComparable("discountId", java.util.UUID.class);

	public final NumberPath<Long> id = createNumber("id", Long.class);

	public final ComparablePath<java.util.UUID> itemId = createComparable("itemId", java.util.UUID.class);

	public QDiscountedItemEntity(String variable) {
		super(DiscountedItemEntity.class, forVariable(variable));
	}

	public QDiscountedItemEntity(Path<? extends DiscountedItemEntity> path) {
		super(path.getType(), path.getMetadata());
	}

	public QDiscountedItemEntity(PathMetadata metadata) {
		super(DiscountedItemEntity.class, metadata);
	}

}
