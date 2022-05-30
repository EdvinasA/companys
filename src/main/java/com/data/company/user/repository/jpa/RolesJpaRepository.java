package com.data.company.user.repository.jpa;

import com.data.company.user.repository.entity.RolesEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesJpaRepository extends JpaRepository<RolesEntity, UUID> {

}
