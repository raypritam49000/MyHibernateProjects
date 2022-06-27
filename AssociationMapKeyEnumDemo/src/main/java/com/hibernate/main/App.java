package com.hibernate.main;

import com.hibernate.model.Address;
import com.hibernate.model.AddressType;
import com.hibernate.model.Employee;
import com.hibernate.model.PhoneType;
import com.hibernate.session.SessionProvider;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Employee employee = new Employee();
        employee.setName("Pritam Ray");
        employee.setEmail("ray123@gmail.com");
        employee.setSalary(30000.00);
        employee.setDoj(new Date());
        employee.setPhone(8699535683l);
        employee.setPhoneType(PhoneType.MOBILE);
       
        Address address1 = new Address();
        address1.setCity("Ropar");
        address1.setPincode(140001);
        address1.setState("Punjab");
        address1.setStreet("Galaxy Hotel");
        address1.setAddressType(AddressType.PERMANENT);
        
        Address address2 = new Address();
        address2.setCity("Nawashaher");
        address2.setPincode(144533);
        address2.setState("Punjab");
        address2.setStreet("Asron");
        address2.setAddressType(AddressType.COMMUNICATION);
        
        List<Address> addresses = new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);
        
        address1.setEmployee(employee);
        address2.setEmployee(employee);
        
        employee.setAddressList(addresses);
        
        session.beginTransaction();
        
        session.save(employee);
        session.save(address1);
        session.save(address2);
        
        session.getTransaction().commit();
    }
  
}
