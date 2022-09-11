package com.data.company.user.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSubscriptionDetailsEntity is a Querydsl query type for SubscriptionDetailsEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubscriptionDetailsEntity extends EntityPathBase<SubscriptionDetailsEntity> {

    private static final long serialVersionUID = 1608328230L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSubscriptionDetailsEntity subscriptionDetailsEntity = new QSubscriptionDetailsEntity("subscriptionDetailsEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath receiveEmails = createBoolean("receiveEmails");

    public final BooleanPath receiveEmailsAboutGivingFeedback = createBoolean("receiveEmailsAboutGivingFeedback");

    public final DatePath<java.time.LocalDate> receiveEmailsAboutGivingFeedbackDate = createDate("receiveEmailsAboutGivingFeedbackDate", java.time.LocalDate.class);

    public final BooleanPath receiveEmailsAboutLookedItems = createBoolean("receiveEmailsAboutLookedItems");

    public final DatePath<java.time.LocalDate> receiveEmailsAboutLookedItemsDate = createDate("receiveEmailsAboutLookedItemsDate", java.time.LocalDate.class);

    public final BooleanPath receiveEmailsAboutServiceQuality = createBoolean("receiveEmailsAboutServiceQuality");

    public final DatePath<java.time.LocalDate> receiveEmailsAboutServiceQualityDate = createDate("receiveEmailsAboutServiceQualityDate", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> receiveEmailsDate = createDate("receiveEmailsDate", java.time.LocalDate.class);

    public final QUserEntity user;

    public QSubscriptionDetailsEntity(String variable) {
        this(SubscriptionDetailsEntity.class, forVariable(variable), INITS);
    }

    public QSubscriptionDetailsEntity(Path<? extends SubscriptionDetailsEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSubscriptionDetailsEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSubscriptionDetailsEntity(PathMetadata metadata, PathInits inits) {
        this(SubscriptionDetailsEntity.class, metadata, inits);
    }

    public QSubscriptionDetailsEntity(Class<? extends SubscriptionDetailsEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUserEntity(forProperty("user")) : null;
    }

}

