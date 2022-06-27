package com.hibernate.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="creditcard12")
@AttributeOverrides({
	@AttributeOverride(name="paymentId",column = @Column(name="paymentId")),
	@AttributeOverride(name="amount",column = @Column(name="amount"))
})
public class CreditCard extends Payment {
	@Column(name = "creditcard")
	private String creditCardType;

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}
}
