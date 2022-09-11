package com.data.company.companyData.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;

/**
 * QCompanyDataEntity is a Querydsl query type for CompanyDataEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCompanyDataEntity extends EntityPathBase<CompanyDataEntity> {

	private static final long serialVersionUID = 41547828L;

	public static final QCompanyDataEntity companyDataEntity = new QCompanyDataEntity("companyDataEntity");

	public final StringPath address = createString("address");

	public final StringPath code = createString("code");

	public final StringPath companyForm = createString("companyForm");

	public final DatePath<java.time.LocalDate> formattedInformationDate = createDate("formattedInformationDate", java.time.LocalDate.class);

	public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

	public final StringPath name = createString("name");

	public final DatePath<java.time.LocalDate> registeredDate = createDate("registeredDate", java.time.LocalDate.class);

	public final StringPath statusName = createString("statusName");

	public final DatePath<java.time.LocalDate> statusSinceDate = createDate("statusSinceDate", java.time.LocalDate.class);

	public QCompanyDataEntity(String variable) {
		super(CompanyDataEntity.class, forVariable(variable));
	}

	public QCompanyDataEntity(Path<? extends CompanyDataEntity> path) {
		super(path.getType(), path.getMetadata());
	}

	public QCompanyDataEntity(PathMetadata metadata) {
		super(CompanyDataEntity.class, metadata);
	}

}
