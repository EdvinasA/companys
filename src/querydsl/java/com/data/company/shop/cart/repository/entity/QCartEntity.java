package com.data.company.shop.cart.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QCartEntity is a Querydsl query type for CartEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCartEntity extends EntityPathBase<CartEntity> {

	private static final long serialVersionUID = -2093605624L;

	public static final QCartEntity cartEntity = new QCartEntity("cartEntity");

	public final ListPath<CartItemEntity, QCartItemEntity> cartItems = this.<CartItemEntity, QCartItemEntity> createList("cartItems", CartItemEntity.class, QCartItemEntity.class, PathInits.DIRECT2);

	public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

	public final DateTimePath<java.time.LocalDateTime> purchaseDate = createDateTime("purchaseDate", java.time.LocalDateTime.class);

	public final EnumPath<com.data.company.shop.cart.model.CartStatus> status = createEnum("status", com.data.company.shop.cart.model.CartStatus.class);

	public final ComparablePath<java.util.UUID> userId = createComparable("userId", java.util.UUID.class);

	public QCartEntity(String variable) {
		super(CartEntity.class, forVariable(variable));
	}

	public QCartEntity(Path<? extends CartEntity> path) {
		super(path.getType(), path.getMetadata());
	}

	public QCartEntity(PathMetadata metadata) {
		super(CartEntity.class, metadata);
	}

}
