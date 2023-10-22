package com.protocollo.risparmio.brk.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "U_MONTH")
public class UserMonth {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "U_MONTH_SEQUENCE")
  @GenericGenerator(name = "U_MONTH_SEQUENCE", strategy = "uuid2")
  @Column(name = "ID_UMONTH", unique = true, columnDefinition = "BINARY(16)")
  @Basic(optional = false)
  private UUID idUMonth;

  @Basic(optional = false)
  @Column(name = "TITLE")
  private String title;

  @Column(name = "NOTE")
  private String note;

  @Column(name = "DES")
  private String des;

  @Column(name = "SALARY")
  private BigDecimal salary;

  @Column(name = "COST")
  private BigDecimal cost;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "ID_UMONTH", referencedColumnName = "ID_UMONTH", nullable = false)
  private List<Leisure> leisure;

  @Column(name = "TOTALLEISURE")
  private BigDecimal totalLeisure;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "ID_UMONTH", referencedColumnName = "ID_UMONTH", nullable = false)
  private List<FixedMonthlyCredit> fixedMonthlyCredit;

  @Column(name = "TOTALFIXEDMONTHLYCREDIT")
  private BigDecimal totalFixedMonthlyCredit;

  @Column(name = "DIFFERENCE")
  private BigDecimal difference;
}
