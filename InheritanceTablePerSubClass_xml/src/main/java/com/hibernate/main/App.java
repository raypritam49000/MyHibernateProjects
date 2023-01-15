package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Cheque;
import com.hibernate.model.CreditCard;
import com.hibernate.session.SessionProvider;

public class App {
	public static void main(String[] args) {
		Session session = SessionProvider.getSession();
		
		Cheque cheque = new Cheque();
		cheque.setAmount(20000);
		cheque.setChequeType("SBI");

		CreditCard creditCard = new CreditCard();
		creditCard.setAmount(2000);
		creditCard.setCreditCardType("ICIC PLATINUM CREDITCARD");

		Transaction transaction = session.beginTransaction();

		session.save(cheque);
		session.save(creditCard);

		transaction.commit();

	}
}
