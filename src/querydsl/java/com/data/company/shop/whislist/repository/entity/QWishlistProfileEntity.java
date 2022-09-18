package com.data.company.shop.whislist.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QWishlistProfileEntity is a Querydsl query type for WishlistProfileEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWishlistProfileEntity extends EntityPathBase<WishlistProfileEntity> {

	private static final long serialVersionUID = 2013754587L;

	public static final QWishlistProfileEntity wishlistProfileEntity = new QWishlistProfileEntity("wishlistProfileEntity");

	public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

	public final ListPath<WishlistItemEntity, QWishlistItemEntity> items = this.<WishlistItemEntity, QWishlistItemEntity> createList("items", WishlistItemEntity.class, QWishlistItemEntity.class, PathInits.DIRECT2);

	public final StringPath name = createString("name");

	public final ComparablePath<java.util.UUID> userId = createComparable("userId", java.util.UUID.class);

	public QWishlistProfileEntity(String variable) {
		super(WishlistProfileEntity.class, forVariable(variable));
	}

	public QWishlistProfileEntity(Path<? extends WishlistProfileEntity> path) {
		super(path.getType(), path.getMetadata());
	}

	public QWishlistProfileEntity(PathMetadata metadata) {
		super(WishlistProfileEntity.class, metadata);
	}

}
