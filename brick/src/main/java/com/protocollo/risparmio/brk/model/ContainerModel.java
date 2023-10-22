package com.protocollo.risparmio.brk.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Getter
@Setter
public class ContainerModel implements Serializable {

  private UUID idContainer;
  private String codUser;
  private FixedCostModel fixedCost;
  private List<UserMonthModel> months;
}
