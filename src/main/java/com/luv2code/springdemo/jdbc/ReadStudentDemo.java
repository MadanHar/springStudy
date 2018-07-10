package com.luv2code.springdemo.jdbc;

import com.luv2code.springdemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();
            List<Student> studentList = session.createQuery("from Student").list();

            studentList.forEach(s-> System.out.println(s));
            session.getTransaction().commit();

        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            factory.close();

        }

    }
}
