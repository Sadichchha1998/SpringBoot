package com.masai.service;

import java.util.List;

import com.masai.model.User;

public interface UserService {

	public User createUser(User user) ;
	
	public List<User> getAllUser();
	
	public User getUserById(int id);
	
	public User deleteUserById(int id);
	
}
