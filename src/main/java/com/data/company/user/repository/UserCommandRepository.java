package com.data.company.user.repository;

import com.data.company.user.model.SubscriptionDetails;
import com.data.company.user.model.User;
import com.data.company.user.repository.converter.SubscriptionDetailsConverter;
import com.data.company.user.repository.converter.UserConverter;
import com.data.company.user.repository.entity.SubscriptionDetailsEntity;
import com.data.company.user.repository.entity.UserEntity;
import com.data.company.user.repository.jpa.SubscriptionDetailsJpaRepository;
import com.data.company.user.repository.jpa.UserJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class UserCommandRepository {

	private final UserJpaRepository userJpaRepository;
	private final SubscriptionDetailsJpaRepository subscriptionDetailsJpaRepository;
	private final SubscriptionDetailsConverter subscriptionDetailsConverter;
	private final UserConverter userConverter;

	@Transactional
	public User create(User user, SubscriptionDetails subscriptionDetails) {
		UserEntity entity = userConverter.convertToEntity(user);
		SubscriptionDetailsEntity subscriptionDetailsEntity = subscriptionDetailsConverter
				.convertToEntity(subscriptionDetails);
		subscriptionDetailsEntity.setUser(entity);

		UserEntity createdUser = userJpaRepository.save(entity);
		subscriptionDetailsJpaRepository.save(subscriptionDetailsEntity);

		return userConverter.convertFromEntity(createdUser);
	}

	@Transactional
	public void update(User user) {
		UserEntity userEntity = userConverter.convertToEntity(user);
		SubscriptionDetailsEntity subscriptionDetailsEntity = subscriptionDetailsConverter.convertToEntity(user.getSubscriptionDetails());
		subscriptionDetailsEntity.setUser(userEntity);
		userEntity.getDeliveryInformationList()
				.forEach(deliveryInformationEntity -> deliveryInformationEntity.setUser(userEntity));

		userJpaRepository.save(userEntity);
		subscriptionDetailsJpaRepository.save(subscriptionDetailsEntity);

	}
}
