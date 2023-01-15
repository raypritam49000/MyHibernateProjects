package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Cheque;
import com.hibernate.model.CreditCard;
import com.hibernate.session.SessionProvider;

public class App 
{
    public static void main( String[] args )
    {
      Session session = SessionProvider.getSession();
      
      Cheque cheque = new Cheque();
      cheque.setAmount(19989);
      cheque.setChequeType("HDFC BANK CHEQUE");
      
      CreditCard creditCard = new CreditCard();
      creditCard.setAmount(50000);
      creditCard.setCreditCardType("SBI PLATINUM CARD");
      
      Transaction transaction = session.beginTransaction();
      
      session.save(cheque);
      session.save(creditCard);
      
      transaction.commit();
      
    }
}
