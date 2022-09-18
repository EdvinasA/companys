package com.data.company.jwt.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;

/**
 * QTokenEntity is a Querydsl query type for TokenEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTokenEntity extends EntityPathBase<TokenEntity> {

	private static final long serialVersionUID = -1897984666L;

	public static final QTokenEntity tokenEntity = new QTokenEntity("tokenEntity");

	public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

	public final StringPath email = createString("email");

	public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

	public final StringPath token = createString("token");

	public QTokenEntity(String variable) {
		super(TokenEntity.class, forVariable(variable));
	}

	public QTokenEntity(Path<? extends TokenEntity> path) {
		super(path.getType(), path.getMetadata());
	}

	public QTokenEntity(PathMetadata metadata) {
		super(TokenEntity.class, metadata);
	}

}
