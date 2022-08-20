package com.data.company.user.repository;

import com.data.company.user.model.User;
import com.data.company.user.repository.converter.UserConverter;
import com.data.company.user.repository.entity.UserEntity;
import com.data.company.user.repository.jpa.UserJpaRepository;
import java.util.Optional;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class UserQueryRepository {

	private final UserJpaRepository userJpaRepository;
	private final UserConverter converter;

	@Transactional
	public User getUserByEmail(String email) {
		Optional<UserEntity> user = userJpaRepository.findByEmail(email);
		return user
				.map(converter::convertFromEntity)
				.orElseThrow(EntityNotFoundException::new);
	}

	@Transactional
	public User findUserByEmail(String email) {
		return userJpaRepository.findByEmail(email)
				.map(converter::convertFromEntity)
				.orElse(new User());
	}

	@Transactional
	public User findById(UUID userId) {
		return userJpaRepository.findById(userId)
				.map(converter::convertFromEntity)
				.orElseThrow(EntityNotFoundException::new);
	}
}
