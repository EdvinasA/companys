package com.data.company.shop.products.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QProductEntity is a Querydsl query type for ProductEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductEntity extends EntityPathBase<ProductEntity> {

	private static final long serialVersionUID = 935771121L;

	private static final PathInits INITS = PathInits.DIRECT2;

	public static final QProductEntity productEntity = new QProductEntity("productEntity");

	public final EnumPath<com.data.company.shop.products.model.Category> category = createEnum("category", com.data.company.shop.products.model.Category.class);

	public final StringPath code = createString("code");

	public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

	public final StringPath name = createString("name");

	public final com.data.company.shop.orders.repository.entities.QOrderedItemsEntity orderedItems;

	public final StringPath picture = createString("picture");

	public final NumberPath<Double> price = createNumber("price", Double.class);

	public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

	public final StringPath stripePriceId = createString("stripePriceId");

	public final StringPath stripeProductId = createString("stripeProductId");

	public final EnumPath<com.data.company.shop.products.model.SubCategory> subCategory = createEnum("subCategory", com.data.company.shop.products.model.SubCategory.class);

	public final StringPath type = createString("type");

	public QProductEntity(String variable) {
		this(ProductEntity.class, forVariable(variable), INITS);
	}

	public QProductEntity(Path<? extends ProductEntity> path) {
		this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
	}

	public QProductEntity(PathMetadata metadata) {
		this(metadata, PathInits.getFor(metadata, INITS));
	}

	public QProductEntity(PathMetadata metadata, PathInits inits) {
		this(ProductEntity.class, metadata, inits);
	}

	public QProductEntity(Class<? extends ProductEntity> type, PathMetadata metadata, PathInits inits) {
		super(type, metadata, inits);
		this.orderedItems = inits.isInitialized("orderedItems") ? new com.data.company.shop.orders.repository.entities.QOrderedItemsEntity(forProperty("orderedItems"), inits.get("orderedItems")) : null;
	}

}
