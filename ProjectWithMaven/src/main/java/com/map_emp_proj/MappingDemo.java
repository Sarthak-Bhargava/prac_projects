package com.map_emp_proj;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		
		SessionFactory factory  = new Configuration().configure().buildSessionFactory();
		
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		
		e1.setEid(34);
		e1.setName("Satyam");
		
		e2.setEid(35);
		e2.setName("Akash");
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setPid(9619);
		p1.setProjectName("Liquidity Management system");
		
		p2.setPid(1456);
		p2.setProjectName("Supply chain management");
		
		List<Emp> list1 = new ArrayList<Emp>();
		List<Project> list2 = new ArrayList<Project>();
		
		list1.add(e1);
		list1.add(e2);
		
		list2.add(p1);
		list2.add(p2);
		
		e1.setProjects(list2); 
		
		p2.setEmps(list1);
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Done");
		
		
		
		
		
		
		factory.close();
		

	}

}
