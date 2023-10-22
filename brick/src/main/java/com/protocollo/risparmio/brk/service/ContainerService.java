package com.protocollo.risparmio.brk.service;

import com.protocollo.risparmio.brk.entity.ContainerEntity;
import com.protocollo.risparmio.brk.mapper.ContainerMapper;
import com.protocollo.risparmio.brk.model.ContainerModel;
import com.protocollo.risparmio.brk.model.UserMonthModel;
import com.protocollo.risparmio.brk.repository.ContainerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class ContainerService {

  @Autowired ContainerRepository containerRepository;
  @Autowired ContainerMapper mapper;

  public ContainerModel insert(ContainerModel model) {
    log.info("<<<<<<< Start Insert new Container with codUser : {} >>>>>>>", model.getCodUser());
    return mapper.toModel(containerRepository.saveAndFlush(mapper.toEntity(model)));
  }

  public ContainerModel search(String codUser) {
    log.info("<<<<<<< Start Search Container with codUser : {} >>>>>>>", codUser);
    return mapper.toModel(containerRepository.findByCodUser(codUser));
  }

  public ContainerModel update(ContainerModel model) {
    log.info("<<<<<<< Start Update Container with codUser : {} >>>>>>>", model.getCodUser());
    return mapper.toModel(containerRepository.saveAndFlush(mapper.toEntity(model)));
  }

  public Boolean deleteAllContainers(String codUser) {
    log.info("<<<<<<< Start Delete ALL Container with codUser : {} >>>>>>>", codUser);
    ContainerEntity container = containerRepository.findByCodUser(codUser);
    if (Objects.nonNull(container)) {
      containerRepository.delete(container);
      log.info("<<<<<<< End Delete ALL Container with codUser : {} >>>>>>>", codUser);
      return true;
    }
    log.info("<<<<<<< Empty list ALL Container with codUser : {} >>>>>>>", codUser);
    return false;
  }

  public Boolean delete(UUID idContainer) {
    log.info("<<<<<<< Start Delete Container with id : {} >>>>>>>", idContainer);
    if (containerRepository.existsById(idContainer)) {
      containerRepository.deleteById(idContainer);
      log.info("<<<<<<< End Delete Container with id : {}  >>>>>>>", idContainer);
      return true;
    }
    log.info("<<<<<<< Not found Delete Container with id : {} >>>>>>>", idContainer);
    return false;
  }

  /**
   * Cerca i mesi IN LIKE
   *
   * @param codUser
   * @param value
   * @return
   */
  public ContainerModel searchMouthInLike(String codUser, String value) {
    log.info(
        "<<<<<<< Start Search Mouth InLike with codUser {} and value {} : >>>>>>>", codUser, value);
    ContainerModel search = search(codUser);
    if (Objects.nonNull(search)
        && Objects.nonNull(search.getMonths())
        && !search.getMonths().isEmpty()) {
      List<UserMonthModel> months =
          search.getMonths().stream()
              .filter(
                  a ->
                      Objects.nonNull(a.getTitle())
                          && a.getTitle().toLowerCase().contains(value.toLowerCase()))
              .collect(Collectors.toList());
      search.getMonths().clear();
      search.getMonths().addAll(months);
      log.info("<<<<<<< Result found Search Mouth InLike : {}  >>>>>>>", months.size());
    }
    return search;
  }
}
