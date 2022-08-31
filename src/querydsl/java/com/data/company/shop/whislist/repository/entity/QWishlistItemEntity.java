package com.data.company.shop.whislist.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QWishlistItemEntity is a Querydsl query type for WishlistItemEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWishlistItemEntity extends EntityPathBase<WishlistItemEntity> {

    private static final long serialVersionUID = -2133978809L;

    public static final QWishlistItemEntity wishlistItemEntity = new QWishlistItemEntity("wishlistItemEntity");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final StringPath itemCode = createString("itemCode");

    public final ComparablePath<java.util.UUID> itemId = createComparable("itemId", java.util.UUID.class);

    public final StringPath itemName = createString("itemName");

    public final StringPath itemPicture = createString("itemPicture");

    public final NumberPath<Double> itemPrice = createNumber("itemPrice", Double.class);

    public final ComparablePath<java.util.UUID> wishListProfileId = createComparable("wishListProfileId", java.util.UUID.class);

    public QWishlistItemEntity(String variable) {
        super(WishlistItemEntity.class, forVariable(variable));
    }

    public QWishlistItemEntity(Path<? extends WishlistItemEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWishlistItemEntity(PathMetadata metadata) {
        super(WishlistItemEntity.class, metadata);
    }

}

