package com.protocollo.risparmio.brk.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Getter
@Setter
public class FixedCostModel implements Serializable {
  private UUID idFixedCost;
  private BigDecimal totalFixedCost;
  private List<CostModel> costs;
}
