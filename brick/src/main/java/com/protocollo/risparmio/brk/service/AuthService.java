package com.protocollo.risparmio.brk.service;

import com.protocollo.risparmio.brk.entity.ContainerEntity;
import com.protocollo.risparmio.brk.entity.UserContainerEntity;
import com.protocollo.risparmio.brk.mapper.ContainerMapper;
import com.protocollo.risparmio.brk.model.UserContainerModel;
import com.protocollo.risparmio.brk.repository.AuthRepository;
import com.protocollo.risparmio.brk.repository.ContainerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class AuthService {

  @Autowired AuthRepository authRepository;
  @Autowired ContainerRepository containerRepository;
  @Autowired ContainerMapper mapper;

  public UserContainerModel insert(UserContainerModel model) {
    log.info("<<<<<<< Start Insert new User >>>>>>>");
    UserContainerEntity entity = authRepository.saveAndFlush(mapper.toUserEntity(model));
    log.info("<<<<<<< Create Container for new User >>>>>>>");
    ContainerEntity containerEntity = new ContainerEntity();
    containerEntity.setCodUser(entity.getEmail());
    containerEntity.setMonths(Collections.emptyList());
    log.info("<<<<<<< Save Container for new User >>>>>>>");
    containerRepository.saveAndFlush(containerEntity);
    log.info("<<<<<<< End Insert new User >>>>>>>");
    return mapper.toUserModel(entity);
  }

  public UserContainerModel search(String email) {
    log.info("<<<<<<< Start Search User {} >>>>>>>", email);
    return Optional.ofNullable(mapper.toUserModel(authRepository.findByEmail(email)))
        .orElseThrow(() -> new RuntimeException("Not found email " + email));
  }

  public UserContainerModel update(UserContainerModel model) {
    log.info("<<<<<<< Start Update User >>>>>>>");
    return mapper.toUserModel(authRepository.saveAndFlush(mapper.toUserEntity(model)));
  }

  public Boolean delete(String email) {
    log.info("<<<<<<< Start Delete User {} >>>>>>>", email);
    UserContainerModel model = search(email);
    if (Objects.nonNull(model)) {
      // Delete User
      authRepository.deleteById(model.getIdUserContainer());
      // TODO : Delete Container User
      log.info("<<<<<<< Delete Container User {} >>>>>>>", email);

      log.info("<<<<<<< End Delete User {} >>>>>>>", email);
      return true;
    }
    log.info("<<<<<<< Not found User {} >>>>>>>", email);
    return false;
  }
}
