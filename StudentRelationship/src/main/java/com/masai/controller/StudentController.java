package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.Student;
import com.masai.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService sService;
	/*
	 {
"name": "Ram",
    "marks": 900,
    "addr":{
        "state":"hM",
        "city":"Goa",
        "pincode":"12334"
    }
}
	 */
	@PostMapping("/students/{cname}")
public	ResponseEntity<Student> registerStudentInCourse (@PathVariable ("cname") String cname, @RequestBody Student student) throws StudentException, CourseException{
		  Student enrolledStudent =sService.registerStudentInCourse(cname, student);
		  return new ResponseEntity<Student>(enrolledStudent,HttpStatus.CREATED);
	}

@GetMapping("/students/{cname}")
	public ResponseEntity<List<Student>> getStudentByCnameHandler(@PathVariable ("cname") String cname) throws CourseException{
		
	List<Student> students = sService.findStudentByCname(cname);
	
 return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
}
}
