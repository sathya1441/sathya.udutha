package com.hibernate_example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Main {
    public static void main(String[] args) {

        // Laptop lap1 = new Laptop();
        // lap1.setLaptopId(103);
        // lap1.setLaptopName("MacBook Air");
        // lap1.setLaptopBrand("Apple");

        // Laptop lap2 = new Laptop();
        // lap2.setLaptopId(104);
        // lap2.setLaptopName("Surface Book");
        // lap2.setLaptopBrand("Microsoft");

        // Laptop lap3 = new Laptop();
        // lap3.setLaptopId(105);
        // lap3.setLaptopName("ThinkPad");
        // lap3.setLaptopBrand("Lenovo");

        // Employee emp2 =new Employee();
        // emp2.setEmployeeId(1);
        // emp2.setEmployeeName("Hari");
        // emp2.setDepartmentID("CSE");
        // List<Laptop> listOf = List.of(lap1,lap2,lap3);
        // emp2.setLaptop(listOf);

        // lap1.setEmployee(emp2);
        // lap2.setEmployee(emp2);
        // lap3.setEmployee(emp2);
        Configuration cfg = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Laptop.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("select laptopName, LaptopBrand from Laptop where laptopBrand like ?1");
        query.setParameter(1, "Apple%");
        List<Object[]> laptops = query.getResultList();
        for(Object[] lap : laptops){
            System.out.println("Laptop Name: " + lap[0] + ", Laptop ID: " + lap[1]);
        }
        // System.out.println(laptops);
        session.close();
    }
}