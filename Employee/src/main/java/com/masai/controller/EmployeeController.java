package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Address;
import com.masai.model.Employee;
import com.masai.repository.EmployeeRepo;
import com.masai.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	@Autowired
	private EmployeeRepo empRepo;

	@PostMapping("/employee")
	public ResponseEntity<Employee> registerEmployee(@RequestBody Employee emp) {

		return new ResponseEntity<Employee>(empService.registerEmployee(emp), HttpStatus.CREATED);

	}

	@GetMapping("/get/employee")
	public ResponseEntity<Employee> getEmployeeById(@RequestParam("id") int id) {

		return new ResponseEntity<Employee>(empService.getEmployeeById(id), HttpStatus.OK);

	}

	@GetMapping("/get/Allemployees")
	public ResponseEntity<List<Employee>> getAllEmployees(@RequestBody Employee employee) {

		return new ResponseEntity<List<Employee>>(empService.getAllEmployeeDetails(), HttpStatus.OK);

	}

	@DeleteMapping("/delete/employee/{id}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable("id") int id) {

		return new ResponseEntity<Employee>(empService.deleteEmployeeById(id), HttpStatus.OK);

	}
     @GetMapping("/login/{email}/{password}")
	public ResponseEntity<Employee> loginEmployee(@PathVariable("email") String email,
			@PathVariable("password") String password) {
		return new ResponseEntity<Employee>(empService.loginEmployee(email, password),HttpStatus.ACCEPTED);

	}
//     @PostMapping("/getByAddress")
//     public ResponseEntity<List<Employee>> getAllemployeeByAddress(@RequestBody Address address) {
//         return new ResponseEntity<>(empService.getEmployeeDetailsByAddress( address), HttpStatus.ACCEPTED);
//     }
}
