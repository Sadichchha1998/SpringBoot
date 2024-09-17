package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.Course;
import com.masai.model.Student;
import com.masai.repository.CourseDao;
import com.masai.repository.StudentDao;
@Service
public class StudentServiceImpl implements StudentService {
@Autowired
	private StudentDao sDao;
@Autowired
	private CourseDao cDao;
	@Override
	public Student registerStudentInCourse(String cname, Student student) throws StudentException, CourseException {
	
	Course course	= cDao.getCourseByCname(cname);
	
	if (course != null) {
		 course.getStudents().add(student);
		 student.getCourses().add(course);
		 return sDao.save(student);
		
	}else {
		throw new CourseException("course not found with name "+cname);
	}
	}

}
