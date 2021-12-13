package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		
		SessionFactory factory  = new Configuration().configure().buildSessionFactory();
		Student student1 = new Student();
		student1.setId(1434);
		student1.setName("Akash");
		student1.setCity("Pune");
		
		Certificate certificate = new Certificate();
		certificate.setCourse("Android");
		certificate.setDuration(" 3 months");
		student1.setCerti(certificate);
		
		Student student2 = new Student();
		student2.setId(1256);
		student2.setName("Satyam");
		student2.setCity("Vidisha");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("iOS");
		certificate1.setDuration("2.5 months");
		student1.setCerti(certificate1);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		// Objects save
		s.save(student1);
		s.save(student2);
		
		tx.commit();
		
		
		
		s.close();
		factory.close();
	}

}
