package com.protocollo.risparmio.brk.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Getter
@Setter
public class FixedMonthlyCreditModel implements Serializable {

  private UUID idFixedMonthlyCredit;
  private String note;
  private BigDecimal price;
}
