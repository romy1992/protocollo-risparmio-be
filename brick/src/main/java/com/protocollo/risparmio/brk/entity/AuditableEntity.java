package com.protocollo.risparmio.brk.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditableEntity {

	@Column(name = "NOTE")
	private String note;

	@Column(name = "PRICE")
	private BigDecimal price;
}
