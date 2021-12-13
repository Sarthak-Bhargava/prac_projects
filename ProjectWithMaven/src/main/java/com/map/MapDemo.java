package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		SessionFactory factory  = new Configuration().configure().buildSessionFactory();
		
		// Creating question
		Question q1 = new Question();
		q1.setQuestionId(1244);
		q1.setQuestion("What is java ?");
		
		// creating answer
		Answer answer = new Answer();
		answer.setAnswerId(433);
		answer.setAnswer("Java is programming language");
		answer.setQuestion(q1);
//		q1.setAnswer(answer);
		
		Answer answer1 = new Answer();
		answer1.setAnswerId(133);
		answer1.setAnswer("With the help of java we cab create applications.");
		answer1.setQuestion(q1);
		
		Answer answer2 = new Answer();
		answer2.setAnswerId(333);
		answer2.setAnswer("Java is programming language to create web-app");
		answer2.setQuestion(q1);
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);
		
		q1.setAnswers(list);
		
		
		// session
		Session session = factory.openSession();
		session.beginTransaction();
		
//		s.save(q1);
//		s.save(answer);
		
		session.save(q1);
		session.save(answer);
		session.save(answer1);
		session.save(answer2);
		
		session.getTransaction().commit();
		session.close();
		
		
		// fetching 
		Question newQ = (Question)session.get(Question.class, 1243);
		System.out.println(newQ.getQuestion());
		System.out.println( newQ.getAnswers().getAnswer());
		
		
		
		
		
		
		
		
		
		
		factory.close();

	}

}
