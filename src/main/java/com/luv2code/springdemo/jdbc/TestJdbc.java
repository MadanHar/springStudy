package com.luv2code.springdemo.jdbc;


import com.luv2code.springdemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            System.out.println("Creating a new student object");
            Student tempStudent = new Student("Paul","Haraginadoni","dhmadan@gmail.com");

            session.beginTransaction();
            System.out.println("Saving the Student object");
            session.save(tempStudent);
            session.getTransaction().commit();

        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            factory.close();

        }

    }
}
