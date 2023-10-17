package com.protocollo.risparmio.brk.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "COST")
public class Cost extends AuditableEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COST_SEQUENCE")
  @GenericGenerator(name = "COST_SEQUENCE", strategy = "uuid2")
  @Column(name = "IDCOST", unique = true, columnDefinition = "BINARY(16)")
  @Basic(optional = false)
  private UUID idCost;
}
