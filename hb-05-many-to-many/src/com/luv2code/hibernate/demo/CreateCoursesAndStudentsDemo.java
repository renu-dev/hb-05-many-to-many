package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

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
			
			//create some courses
			Course tempCourse = new Course("Java");
			//Course course2 = new Course("SpringBoot");
			
			//create students
			Student tempStudent1 = new Student("Jon","Doe","jon@luv2code.com");
			Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");
			
			//add students
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			//save students
			System.out.println("Saving the students");
			session.save(tempStudent1);
			session.save(tempStudent2);
			
			//save the courses
			System.out.println("Saving the course");
			session.save(tempCourse);
			//session.save(course2);
			
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
