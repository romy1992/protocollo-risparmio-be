package com.protocollo.risparmio.brk.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class FixedCostModel {
  private UUID idFixedCost;
  private BigDecimal totalFixedCost;
  private List<CostModel> costs;
}
