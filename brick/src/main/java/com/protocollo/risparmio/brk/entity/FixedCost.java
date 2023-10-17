package com.protocollo.risparmio.brk.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "FIXEDCOST")
public class FixedCost {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FIXEDCOST_SEQUENCE")
  @GenericGenerator(name = "FIXEDCOST_SEQUENCE", strategy = "uuid2")
  @Column(name = "IDFIXEDCOST", unique = true, columnDefinition = "BINARY(16)")
  @Basic(optional = false)
  private UUID idFixedCost;

  @Column(name = "TOTALFIXEDCOST")
  private BigDecimal totalFixedCost;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Cost> costs;
}
