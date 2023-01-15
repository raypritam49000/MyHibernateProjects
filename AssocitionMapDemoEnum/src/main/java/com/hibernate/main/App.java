package com.hibernate.main;

import com.hibernate.model.Car;
import com.hibernate.model.Owner;
import com.hibernate.model.WheelDrive;
import com.hibernate.session.SessionProvider;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {
        System.out.println("Staring the Projects......");
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Owner owner = new Owner();
        owner.setName("Pritam Ray");
        
        Car car1 = new Car();
        car1.setWheelDrive(WheelDrive.WD2);
        
        Car car2 = new Car();
        car2.setWheelDrive(WheelDrive.WD4);
        
        Map<WheelDrive,Car> carMap = new HashMap<>();
        carMap.put(WheelDrive.WD4, car1);
        carMap.put(WheelDrive.WD2, car2);
        
        owner.setCarMap(carMap);
        car1.setOwner(owner);
        car2.setOwner(owner);
        
        session.beginTransaction();
        
        session.save(owner);
        session.save(car1);
        session.save(car2);
        
        session.getTransaction().commit();
        System.out.println("Projects cab be run sucessfully.....");
    }
  
}
