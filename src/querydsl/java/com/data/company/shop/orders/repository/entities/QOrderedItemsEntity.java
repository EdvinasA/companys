package com.data.company.shop.orders.repository.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderedItemsEntity is a Querydsl query type for OrderedItemsEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderedItemsEntity extends EntityPathBase<OrderedItemsEntity> {

    private static final long serialVersionUID = -303955080L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderedItemsEntity orderedItemsEntity = new QOrderedItemsEntity("orderedItemsEntity");

    public final EnumPath<com.data.company.shop.products.model.Category> category = createEnum("category", com.data.company.shop.products.model.Category.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath itemCode = createString("itemCode");

    public final ComparablePath<java.util.UUID> itemId = createComparable("itemId", java.util.UUID.class);

    public final BooleanPath itemInsurance = createBoolean("itemInsurance");

    public final StringPath itemName = createString("itemName");

    public final NumberPath<Double> itemPrice = createNumber("itemPrice", Double.class);

    public final NumberPath<Integer> itemQuantity = createNumber("itemQuantity", Integer.class);

    public final BooleanPath itemWarranty = createBoolean("itemWarranty");

    public final QOrderEntity order;

    public final StringPath picture = createString("picture");

    public final EnumPath<com.data.company.shop.products.model.SubCategory> subCategory = createEnum("subCategory", com.data.company.shop.products.model.SubCategory.class);

    public QOrderedItemsEntity(String variable) {
        this(OrderedItemsEntity.class, forVariable(variable), INITS);
    }

    public QOrderedItemsEntity(Path<? extends OrderedItemsEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrderedItemsEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrderedItemsEntity(PathMetadata metadata, PathInits inits) {
        this(OrderedItemsEntity.class, metadata, inits);
    }

    public QOrderedItemsEntity(Class<? extends OrderedItemsEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.order = inits.isInitialized("order") ? new QOrderEntity(forProperty("order")) : null;
    }

}

