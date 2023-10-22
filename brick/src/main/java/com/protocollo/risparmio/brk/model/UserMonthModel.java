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
public class UserMonthModel implements Serializable {

  private UUID idUMonth;
  private String title;
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
