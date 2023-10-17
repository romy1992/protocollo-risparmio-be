package com.protocollo.risparmio.brk.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class LeisureModel {

  private UUID idLeisure;
  private String note;
  private BigDecimal price;
}
