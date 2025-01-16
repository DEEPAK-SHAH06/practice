package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.Restriction;

public class Test {
	
	public static void main(String[] args) {
		add();
		//getAll();
		//update();
		//delete();
	}
	
	//add Student
	static void add() { 
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Student s =new Student();
		
		s.setFname("Prashant");
		s.setLname("shah");
		s.setAge(2);
		s.setCity("Rajbiraj");
		s.setCollege("Prasadi");
		
		session.save(s);//insert sql write
		session.getTransaction().commit();//execute sql
		session.close();
		
	}
	
	//select from student table 
	static void getAll() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		
		Criteria crt = session.createCriteria(Student.class);
		crt.add(Restrictions.gt("age",34));
		//crt.add(Restrictions.eq("city", "Rajbiraj"));
		crt.addOrder(Order.asc("fname"));
		List<Student> slist = crt.list();//select sql 
		
		System.out.println(slist);
		
	}
	
	//update student 
	static void update(){
		
		@SuppressWarnings("deprecation")
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Student s = (Student) session.get(Student.class, 2);
		s.setCollege("ISMT");
		s.setAge(31);
		
		session.update(s);  //update sql
		//write query ma commit garnu parxa
		session.getTransaction().commit();
		session.close();
		
	}
	
	//delete Student 
	
	static void delete() {
		
		@SuppressWarnings("deprecation")
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Student s = (Student) session.get(Student.class, 4);
		session.delete(s); //delete sql 
		session.getTransaction().commit();
		session.close();
		
	}
	
	
	
	
	
	
	
	

}
