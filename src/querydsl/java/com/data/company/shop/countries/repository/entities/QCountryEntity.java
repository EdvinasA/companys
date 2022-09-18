package com.data.company.shop.countries.repository.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;

/**
 * QCountryEntity is a Querydsl query type for CountryEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCountryEntity extends EntityPathBase<CountryEntity> {

	private static final long serialVersionUID = -125825434L;

	public static final QCountryEntity countryEntity = new QCountryEntity("countryEntity");

	public final NumberPath<Long> id = createNumber("id", Long.class);

	public final StringPath name = createString("name");

	public QCountryEntity(String variable) {
		super(CountryEntity.class, forVariable(variable));
	}

	public QCountryEntity(Path<? extends CountryEntity> path) {
		super(path.getType(), path.getMetadata());
	}

	public QCountryEntity(PathMetadata metadata) {
		super(CountryEntity.class, metadata);
	}

}
