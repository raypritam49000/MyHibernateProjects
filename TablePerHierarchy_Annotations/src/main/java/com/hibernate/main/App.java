package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Cheque;
import com.hibernate.model.CreditCard;
import com.hibernate.session.SessionProvider;

public class App {
	public static void main(String[] args) {
		System.out.println("Starting the Project....");
		Session session = SessionProvider.getSession();
		System.out.println(session);

		Cheque cheque = new Cheque();
		cheque.setAmount(7500);
		cheque.setPaymentId(755349393);
		cheque.setChequeType("Axis Bank Cheque");

		CreditCard creditCard = new CreditCard();
		creditCard.setAmount(3468);
		creditCard.setCreditCardType("PNB Credit Card");
		creditCard.setPaymentId(849393392);

		Transaction transaction = session.beginTransaction();

		session.save(cheque);
		session.save(creditCard);

		session.getTransaction().commit();
		System.out.println("Table Per Hierarchy Successfully done.....");
	}
}
