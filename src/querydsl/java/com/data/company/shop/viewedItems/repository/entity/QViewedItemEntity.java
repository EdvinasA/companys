package com.data.company.shop.viewedItems.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;

/**
 * QViewedItemEntity is a Querydsl query type for ViewedItemEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QViewedItemEntity extends EntityPathBase<ViewedItemEntity> {

	private static final long serialVersionUID = 720453315L;

	public static final QViewedItemEntity viewedItemEntity = new QViewedItemEntity("viewedItemEntity");

	public final BooleanPath delivery = createBoolean("delivery");

	public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

	public final StringPath itemCode = createString("itemCode");

	public final ComparablePath<java.util.UUID> itemId = createComparable("itemId", java.util.UUID.class);

	public final StringPath itemName = createString("itemName");

	public final StringPath itemPicture = createString("itemPicture");

	public final NumberPath<Double> itemPrice = createNumber("itemPrice", Double.class);

	public final ComparablePath<java.util.UUID> userId = createComparable("userId", java.util.UUID.class);

	public final BooleanPath withdrawal = createBoolean("withdrawal");

	public QViewedItemEntity(String variable) {
		super(ViewedItemEntity.class, forVariable(variable));
	}

	public QViewedItemEntity(Path<? extends ViewedItemEntity> path) {
		super(path.getType(), path.getMetadata());
	}

	public QViewedItemEntity(PathMetadata metadata) {
		super(ViewedItemEntity.class, metadata);
	}

}
