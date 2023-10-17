package com.protocollo.risparmio.brk.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "LEISURE")
public class Leisure extends AuditableEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LEISURE_SEQUENCE")
  @GenericGenerator(name = "LEISURE_SEQUENCE", strategy = "uuid2")
  @Column(name = "IDLEISURE", unique = true, columnDefinition = "BINARY(16)")
  @Basic(optional = false)
  private UUID idLeisure;
}
