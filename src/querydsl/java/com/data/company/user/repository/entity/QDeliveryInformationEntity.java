package com.data.company.user.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDeliveryInformationEntity is a Querydsl query type for DeliveryInformationEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDeliveryInformationEntity extends EntityPathBase<DeliveryInformationEntity> {

    private static final long serialVersionUID = -954856423L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDeliveryInformationEntity deliveryInformationEntity = new QDeliveryInformationEntity("deliveryInformationEntity");

    public final StringPath address = createString("address");

    public final StringPath city = createString("city");

    public final StringPath companyAddress = createString("companyAddress");

    public final StringPath companyCode = createString("companyCode");

    public final StringPath companyName = createString("companyName");

    public final StringPath companyPVMCode = createString("companyPVMCode");

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastName = createString("lastName");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath postalCode = createString("postalCode");

    public final QUserEntity user;

    public QDeliveryInformationEntity(String variable) {
        this(DeliveryInformationEntity.class, forVariable(variable), INITS);
    }

    public QDeliveryInformationEntity(Path<? extends DeliveryInformationEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDeliveryInformationEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDeliveryInformationEntity(PathMetadata metadata, PathInits inits) {
        this(DeliveryInformationEntity.class, metadata, inits);
    }

    public QDeliveryInformationEntity(Class<? extends DeliveryInformationEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUserEntity(forProperty("user")) : null;
    }

}

