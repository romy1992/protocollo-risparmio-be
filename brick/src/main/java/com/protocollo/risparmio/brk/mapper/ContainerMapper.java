package com.protocollo.risparmio.brk.mapper;

import com.protocollo.risparmio.brk.entity.ContainerEntity;
import com.protocollo.risparmio.brk.entity.UserContainerEntity;
import com.protocollo.risparmio.brk.model.ContainerModel;
import com.protocollo.risparmio.brk.model.UserContainerModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContainerMapper {

  UserContainerModel toUserModel(UserContainerEntity entity);

  UserContainerEntity toUserEntity(UserContainerModel model);

  ContainerModel toModel(ContainerEntity entity);

  ContainerEntity toEntity(ContainerModel model);
}
