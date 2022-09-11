package com.data.company.shop.discount.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDiscountEntity is a Querydsl query type for DiscountEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDiscountEntity extends EntityPathBase<DiscountEntity> {

    private static final long serialVersionUID = -1418684952L;

    public static final QDiscountEntity discountEntity = new QDiscountEntity("discountEntity");

    public final StringPath code = createString("code");

    public final BooleanPath forAllItems = createBoolean("forAllItems");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final NumberPath<Integer> percent = createNumber("percent", Integer.class);

    public final DatePath<java.time.LocalDate> validUntil = createDate("validUntil", java.time.LocalDate.class);

    public QDiscountEntity(String variable) {
        super(DiscountEntity.class, forVariable(variable));
    }

    public QDiscountEntity(Path<? extends DiscountEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDiscountEntity(PathMetadata metadata) {
        super(DiscountEntity.class, metadata);
    }

}

