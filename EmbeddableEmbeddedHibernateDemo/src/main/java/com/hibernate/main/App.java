package com.hibernate.main;

import com.hibernate.model.Company;
import com.hibernate.model.ContactPerson;
import com.hibernate.session.SessionProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
        System.out.println("Starting the Projects.....");
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Company company = new Company();
        company.setCompany_name("DCM");
        company.setCompany_address("Prem Nagar");
        
        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setFirstName("Chandan");
        contactPerson.setLastName("Kumar");
        contactPerson.setPhone("8699535682");
        
        company.setContactPerson(contactPerson);
        
        Transaction transaction = session.beginTransaction();
        
        session.save(company);
        
        transaction.commit();
        System.out.println("Object are saved Sucessfully...");
        
        
    }
}
