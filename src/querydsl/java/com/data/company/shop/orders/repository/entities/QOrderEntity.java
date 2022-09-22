package com.data.company.shop.orders.repository.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QOrderEntity is a Querydsl query type for OrderEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderEntity extends EntityPathBase<OrderEntity> {

	private static final long serialVersionUID = -1628492625L;

	public static final QOrderEntity orderEntity = new QOrderEntity("orderEntity");

	public final NumberPath<Double> appliedDiscountAmount = createNumber("appliedDiscountAmount", Double.class);

	public final StringPath deliveryAddress = createString("deliveryAddress");

	public final EnumPath<com.data.company.shop.orders.model.DeliveryOption> deliveryOption = createEnum("deliveryOption", com.data.company.shop.orders.model.DeliveryOption.class);

	public final NumberPath<Double> deliveryPrice = createNumber("deliveryPrice", Double.class);

	public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

	public final ComparablePath<java.io.File> invoice = createComparable("invoice", java.io.File.class);

	public final DatePath<java.time.LocalDate> orderDate = createDate("orderDate", java.time.LocalDate.class);

	public final ListPath<OrderedItemsEntity, QOrderedItemsEntity> orderedItems = this.<OrderedItemsEntity, QOrderedItemsEntity> createList("orderedItems", OrderedItemsEntity.class, QOrderedItemsEntity.class, PathInits.DIRECT2);

	public final StringPath orderNumber = createString("orderNumber");

	public final DatePath<java.time.LocalDate> orderUpdate = createDate("orderUpdate", java.time.LocalDate.class);

	public final EnumPath<com.data.company.shop.orders.model.PaymentMethod> paymentMethod = createEnum("paymentMethod", com.data.company.shop.orders.model.PaymentMethod.class);

	public final EnumPath<com.data.company.shop.orders.model.Status> status = createEnum("status", com.data.company.shop.orders.model.Status.class);

	public final NumberPath<Double> totalPrice = createNumber("totalPrice", Double.class);

	public final ComparablePath<java.util.UUID> userId = createComparable("userId", java.util.UUID.class);

	public final StringPath wantedDeliveryTime = createString("wantedDeliveryTime");

	public final StringPath withdrawalLocation = createString("withdrawalLocation");

	public QOrderEntity(String variable) {
		super(OrderEntity.class, forVariable(variable));
	}

	public QOrderEntity(Path<? extends OrderEntity> path) {
		super(path.getType(), path.getMetadata());
	}

	public QOrderEntity(PathMetadata metadata) {
		super(OrderEntity.class, metadata);
	}

}
