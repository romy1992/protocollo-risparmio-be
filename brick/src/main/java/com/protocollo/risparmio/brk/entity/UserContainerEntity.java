package com.protocollo.risparmio.brk.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "USER_CONTAINER")
public class UserContainerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_CONTAINER_SEQUENCE")
  @GenericGenerator(name = "USER_CONTAINER_SEQUENCE", strategy = "uuid2")
  @Column(name = "ID_USER_CONTAINER", unique = true, columnDefinition = "BINARY(16)")
  @Basic(optional = false)
  private UUID idUserContainer;

  @Column(name = "NAME")
  @Basic(optional = false)
  private String name;

  @Column(name = "SURNAME")
  @Basic(optional = false)
  private String surname;

  @Column(name = "EMAIL", unique = true)
  @Basic(optional = false)
  private String email;

  @Column(name = "PASSWORD")
  @Basic(optional = false)
  private String password;
}
