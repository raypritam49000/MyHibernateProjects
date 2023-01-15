package com.hibernate.model;

public class CreditCard extends Payment{
private String creditCardType;

public String getCreditCardType() {
	return creditCardType;
}

public void setCreditCardType(String creditCardType) {
	this.creditCardType = creditCardType;
}

}
