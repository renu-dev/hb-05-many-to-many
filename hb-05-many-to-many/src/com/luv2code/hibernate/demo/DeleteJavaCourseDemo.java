package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteJavaCourseDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
				                 .configure()
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .addAnnotatedClass(Course.class)
				                 .addAnnotatedClass(Review.class)
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//begin or start transaction
			session.beginTransaction();
			
			//get Angular course from database
			int courseId=1;
			Course tempCourse = session.get(Course.class, courseId);
			System.out.println("Java course details are: "+tempCourse);
			
			//delete the course
			System.out.println("Jdeleting the course: "+tempCourse);
			session.delete(tempCourse);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
