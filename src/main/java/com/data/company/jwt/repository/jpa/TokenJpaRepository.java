package com.data.company.jwt.repository.jpa;

import com.data.company.jwt.repository.entity.TokenEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenJpaRepository extends JpaRepository<TokenEntity, UUID> {

	@Query(value = "SELECT * FROM token t WHERE t.token = :token", nativeQuery = true)
	Optional<TokenEntity> findDistinctByToken(@Param("token") String token);
}
