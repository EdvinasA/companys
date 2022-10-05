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

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final com.data.company.shop.products.repository.entity.QProductEntity product;

    public final ComparablePath<java.util.UUID> userId = createComparable("userId", java.util.UUID.class);

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

