package com.masai.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Course;
import com.masai.model.Student;
@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {
// it is non primary key
	public Course findByCourseName(String cname);
	
	//@Query("from Course where courseName=?1")
	//or
	@Query("select c from Course c where c.courseName=?1")
	public Course getCourseByCname(String name);
	
	@Query("select c.students from course c where c.courseName=?1")
 public Set<Student> getStudentsByCname(String cname);

}
