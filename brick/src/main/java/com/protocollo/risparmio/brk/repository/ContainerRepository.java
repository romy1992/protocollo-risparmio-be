package com.protocollo.risparmio.brk.repository;

import com.protocollo.risparmio.brk.entity.ContainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ContainerRepository extends JpaRepository<ContainerEntity, UUID> {
  List<ContainerEntity> findAllByCodUser(String codUser);
}
