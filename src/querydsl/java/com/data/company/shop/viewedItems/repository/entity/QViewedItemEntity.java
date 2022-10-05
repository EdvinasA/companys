package com.data.company.shop.viewedItems.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QViewedItemEntity is a Querydsl query type for ViewedItemEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QViewedItemEntity extends EntityPathBase<ViewedItemEntity> {

    private static final long serialVersionUID = 720453315L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QViewedItemEntity viewedItemEntity = new QViewedItemEntity("viewedItemEntity");

    public final EnumPath<com.data.company.shop.products.model.Category> category = createEnum("category", com.data.company.shop.products.model.Category.class);

    public final BooleanPath delivery = createBoolean("delivery");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final StringPath itemCode = createString("itemCode");

    public final ComparablePath<java.util.UUID> itemId = createComparable("itemId", java.util.UUID.class);

    public final StringPath itemName = createString("itemName");

    public final StringPath itemPicture = createString("itemPicture");

    public final NumberPath<Double> itemPrice = createNumber("itemPrice", Double.class);

    public final com.data.company.shop.products.repository.entity.QProductEntity product;

    public final EnumPath<com.data.company.shop.products.model.SubCategory> subCategory = createEnum("subCategory", com.data.company.shop.products.model.SubCategory.class);

    public final ComparablePath<java.util.UUID> userId = createComparable("userId", java.util.UUID.class);

    public final BooleanPath withdrawal = createBoolean("withdrawal");

    public QViewedItemEntity(String variable) {
        this(ViewedItemEntity.class, forVariable(variable), INITS);
    }

    public QViewedItemEntity(Path<? extends ViewedItemEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QViewedItemEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QViewedItemEntity(PathMetadata metadata, PathInits inits) {
        this(ViewedItemEntity.class, metadata, inits);
    }

    public QViewedItemEntity(Class<? extends ViewedItemEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new com.data.company.shop.products.repository.entity.QProductEntity(forProperty("product")) : null;
    }

}

