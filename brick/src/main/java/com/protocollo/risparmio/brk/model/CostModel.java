package com.protocollo.risparmio.brk.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CostModel {

  private UUID idCost;
  private String note;
  private BigDecimal price;
}
