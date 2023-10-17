package com.protocollo.risparmio.brk.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class UserMonthModel {

  private UUID idUMonth;
  private String name;
  private String note;
  private String des;
  private BigDecimal salary;
  private BigDecimal cost;
  private List<LeisureModel> leisure;
  private BigDecimal totalLeisure;
  private List<FixedMonthlyCreditModel> fixedMonthlyCredit;
  private BigDecimal totalFixedMonthlyCredit;
  private BigDecimal difference;
}
