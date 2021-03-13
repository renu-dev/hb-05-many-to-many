package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
				                 .configure()
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .addAnnotatedClass(Course.class)
				                 .addAnnotatedClass(Review.class)
				                 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//begin or start transaction
			session.beginTransaction();
			
			//create some courses
			Course course1 = new Course("JSP");
			//Course course2 = new Course("SpringBoot");
			
			//add some reviews
			course1.addReview(new Review("good"));
			course1.addReview(new Review("great course"));
			course1.addReview(new Review("loved it"));
			
			course1.addReview(new Review("bad"));
			course1.addReview(new Review("didn't liked it"));
			course1.addReview(new Review("very bad"));
			
			//save the courses
			System.out.println("Saving the course");
			session.save(course1);
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
