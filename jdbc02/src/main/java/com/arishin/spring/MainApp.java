package com.arishin.spring;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
      StudentJDBCTemplate studentJDBCTemplate = 
         (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
      
      Student student = studentJDBCTemplate.getStudent(4);
      System.out.print("ID : " + student.getId() );
      System.out.print(", Name : " + student.getName() );
      System.out.println(", Age : " + student.getAge()); 
   }
}