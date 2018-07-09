package com.luv2code.springdemo.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {
        String jdbcurl = "jdbc:mysql://localhost:3306/hb_student_tracker";
        String user = "hbstudent";
        String password = "hbstudent";
        try{
            System.out.println("Connecting to the database: "+jdbcurl);
            Connection mysql = DriverManager.getConnection(jdbcurl,user,password);
            System.out.println("Connection successful");

        }catch (Exception esc){
            esc.printStackTrace();
        }

    }
}
