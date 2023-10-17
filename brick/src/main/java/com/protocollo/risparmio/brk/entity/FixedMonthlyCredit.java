package com.protocollo.risparmio.brk.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "FIXEDMONTHLYCREDIT")
public class FixedMonthlyCredit extends AuditableEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FIXEDMONTHLYCREDIT_SEQUENCE")
  @GenericGenerator(name = "FIXEDMONTHLYCREDIT_SEQUENCE", strategy = "uuid2")
  @Column(name = "IDFIXEDMONTHLYCREDIT", unique = true, columnDefinition = "BINARY(16)")
  @Basic(optional = false)
  private UUID idFixedMonthlyCredit;
}
