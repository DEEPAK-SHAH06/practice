package com.model;

import java.util.Arrays;
//import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.hibernate.Criteria;
//import org.hibernate.criterion.Order;
//import org.hibernate.criterion.Restrictions;
//import org.hibernate.sql.Restriction;

public class MappingTest {
	
	public static void main(String[] args) {
		oneToOne();
		oneToMany();
		manyToMany();
	}
	//One to one 
	static void oneToOne() {
		@SuppressWarnings("deprecation")
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Address adr = new Address();
		adr.setCountry("Nepal");
		adr.setCity("Ktm");
		adr.setState("Bagmati");
		
		session.save(adr);
		
		Employee emp = new Employee();
		emp.setFname("Roman");
		emp.setLname("Dhami");
		emp.setSalalry(90000);
		emp.setAddress(adr);
		
		session.save(emp);
		session.getTransaction().commit();
		session.close();
	}
	
	//oneToMany
	static void oneToMany() {
		@SuppressWarnings("deprecation")
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Address adr = new Address();
		adr.setCountry("Nepal");
		adr.setCity("Ktm");
		adr.setState("Bagmati");
		
		session.save(adr);
		
		Employee emp = new Employee();
		emp.setFname("Roman");
		emp.setLname("Dhami");
		emp.setSalalry(90000);
		emp.setAddress(adr);
		
		
		Phone p1 = new Phone();
		p1.setNumber("9898948534");
		p1.setType("NCELL");
		p1.setEmployee(emp);
		session.save(p1);
		
		Phone p2 = new Phone();
		p2.setNumber("9834343245");
		p2.setType("NTC");
		p2.setEmployee(emp);
		session.save(p2);
		
		
		emp.setPhoneList(Arrays.asList(p1,p2));
		
		session.save(emp);
		session.getTransaction().commit();
		session.close();
	
	}
	
	static void manyToMany() {
		@SuppressWarnings("deprecation")
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Address adr = new Address();
		adr.setCountry("Nepal");
		adr.setCity("Ktm");
		adr.setState("Bagmati");
		
		session.save(adr);
		
		Employee emp = new Employee();
		emp.setFname("Roman");
		emp.setLname("Dhami");
		emp.setSalalry(90000);
		emp.setAddress(adr);
		
		
		Phone p1 = new Phone();
		p1.setNumber("9898948534");
		p1.setType("NCELL");
		p1.setEmployee(emp);
		session.save(p1);
		
		Phone p2 = new Phone();
		p2.setNumber("9834343245");
		p2.setType("NTC");
		p2.setEmployee(emp);
		session.save(p2);
		
		Department d1 = new Department();
		d1.setName("IT");
		session.save(d1);
		
		Department d2 =new Department();
		d2.setName("Admin");
		session.save(d2);
		
		emp.setDeptList(Arrays.asList(d1,d2));
		emp.setPhoneList(Arrays.asList(p1,p2));
		
		session.save(emp);
		session.getTransaction().commit();
		session.close();
	}

}
