package com.protocollo.risparmio.brk.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "CONTAINER")
public class ContainerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTAINER_SEQUENCE")
  @GenericGenerator(name = "CONTAINER_SEQUENCE", strategy = "uuid2")
  @Column(name = "ID_CONTAINER", unique = true, columnDefinition = "BINARY(16)")
  @Basic(optional = false)
  private UUID idContainer;

  @Column(name = "COD_USER")
  @Basic(optional = false)
  private String codUser;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "IDFIXEDCOST")
  private FixedCost fixedCost;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "ID_CONTAINER", referencedColumnName = "ID_CONTAINER", nullable = false)
  private List<UserMonth> months;
}
