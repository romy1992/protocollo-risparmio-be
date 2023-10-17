package com.protocollo.risparmio.brk.model;

import lombok.Data;

import java.util.UUID;

@Data
public class UserContainerModel {
  private UUID idUserContainer;
  private String name;
  private String surname;
  private String email;
  private String password;
}
