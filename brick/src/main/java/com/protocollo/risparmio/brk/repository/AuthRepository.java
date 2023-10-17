package com.protocollo.risparmio.brk.repository;

import com.protocollo.risparmio.brk.entity.UserContainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthRepository extends JpaRepository<UserContainerEntity, UUID> {

  UserContainerEntity findByEmail(String Email);
}
