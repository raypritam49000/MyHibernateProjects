package com.hibernate.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cheque12")
@AttributeOverrides({
	@AttributeOverride(name="paymentId",column = @Column(name="paymentId")),
	@AttributeOverride(name="amount",column = @Column(name="amount"))
})
public class Cheque extends Payment {
	@Column(name = "cheque")
	private String chequeType;

	public String getChequeType() {
		return chequeType;
	}

	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
}
