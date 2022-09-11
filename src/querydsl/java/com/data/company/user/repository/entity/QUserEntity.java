package com.data.company.user.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QUserEntity is a Querydsl query type for UserEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserEntity extends EntityPathBase<UserEntity> {

	private static final long serialVersionUID = -2032755248L;

	public static final QUserEntity userEntity = new QUserEntity("userEntity");

	public final ListPath<DeliveryInformationEntity, QDeliveryInformationEntity> deliveryInformationList = this.<DeliveryInformationEntity, QDeliveryInformationEntity> createList("deliveryInformationList", DeliveryInformationEntity.class, QDeliveryInformationEntity.class, PathInits.DIRECT2);

	public final StringPath email = createString("email");

	public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

	public final StringPath lastName = createString("lastName");

	public final StringPath name = createString("name");

	public final StringPath password = createString("password");

	public final DatePath<java.time.LocalDate> registeredDate = createDate("registeredDate", java.time.LocalDate.class);

	public final ListPath<String, StringPath> roles = this.<String, StringPath> createList("roles", String.class, StringPath.class, PathInits.DIRECT2);

	public QUserEntity(String variable) {
		super(UserEntity.class, forVariable(variable));
	}

	public QUserEntity(Path<? extends UserEntity> path) {
		super(path.getType(), path.getMetadata());
	}

	public QUserEntity(PathMetadata metadata) {
		super(UserEntity.class, metadata);
	}

}
