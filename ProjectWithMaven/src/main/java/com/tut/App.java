package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started." );
        SessionFactory factory  = new Configuration().configure().buildSessionFactory();
        System.out.println(factory);
        System.out.println(factory.isClosed());
        
        // Creating student 
        Student st = new Student();
        st.setId(102);
        st.setName("John");
        st.setCity("Delhi");
        
        System.out.println(st);
        
        // Creating object of address class
        Address ad = new Address();
        ad.setStreet("streat1");
        ad.setCity("Bhopal");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(2234.67);
        
        // Reading image
        FileInputStream fis = new FileInputStream("src/main/java/2015-11-18_19.43.00.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        Session session =  factory.openSession();
        
        session.beginTransaction();
        session.save(st);
        session.save(ad);
        session.getTransaction().commit();
        session.close();
        System.out.println("Done");
    }
}
