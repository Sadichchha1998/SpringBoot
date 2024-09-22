package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.User;
import com.masai.service.UserService;

@RestController
@RequestMapping("/api")
public class UserEmailController {
	@Autowired
	private UserService userService;
/*
 {
  "name": "John Doe",
  "phoneNo": "1234567890",
  "dateOfBirth": "1990-01-01",
  "email": {
    "email": "johndoe@example.com",
    "createdDate": "2024-09-22"
  }
}

 */
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);

	}
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(@RequestBody User user){
		return new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.OK);
	}
	@GetMapping("/getUserby/{id}")
	public ResponseEntity<User> getUserByID(@PathVariable("id") int id){
		return new ResponseEntity<User>(userService.getUserById(id),HttpStatus.OK);
	}
	@DeleteMapping("deleteMappint")
	public ResponseEntity<User> DeleteUser(@RequestParam ("id")int id,@RequestBody User user){
		return new ResponseEntity<User>(userService.deleteUserById(id),HttpStatus.OK);
	}
	
}
