package com.protocollo.risparmio.brk.model;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ContainerModel {

  private UUID idContainer;
  private String codUser;
  private FixedCostModel fixedCost;
  private List<UserMonthModel> months;
}
