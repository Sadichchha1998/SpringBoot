package com.masai.service;

import java.util.List;
import java.util.Set;

import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.Student;

public interface StudentService {
	public Student registerStudentInCourse(String  cname,Student student ) throws StudentException, CourseException;
public  List<Student>  findStudentByCname(String cname) throws CourseException;
}
