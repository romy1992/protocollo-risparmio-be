package com.protocollo.risparmio.brk.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class FixedMonthlyCreditModel {

  private UUID idFixedMonthlyCredit;
  private String note;
  private BigDecimal price;
}
