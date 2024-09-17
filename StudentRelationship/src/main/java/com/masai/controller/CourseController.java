package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.masai.model.Course;
import com.masai.model.Student;
import com.masai.repository.CourseDao;
import com.masai.service.CourseService;





@RestController
public class CourseController {
   @Autowired
	private CourseService cService;
   @Autowired
   private CourseDao cDao;
  
   /*
    {
    "courseName": "Java",
    "fee": 900,
    "students": [
        {
            "name": "Sadichchha",
            "marks": 900,
            "addr": {
                "state": "MH",
                "city": "Mumbai",
                "pincode": "09000"
            }
        },
          {
            "name": "Akshay",
            "marks": 900,
            "addr": {
                "state": "MH",
                "city": "Pune",
                "pincode": "09000"
            }
          }
    ]
}
 
    */

   @PostMapping("/courses")
   public ResponseEntity<Course> addCourseWithStudents(@RequestBody Course course) {
       // Update the relationship on both sides
       for (Student student : course.getStudents()) {
           student.getCourses().add(course);
       }

       // Save course (this will cascade the save to the students as well)
       Course savedCourse = cDao.save(course);

       return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
   }

}
