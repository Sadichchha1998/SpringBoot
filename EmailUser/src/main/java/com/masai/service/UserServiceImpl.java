package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.UserException;
import com.masai.model.User;
import com.masai.repository.UserRepo;
@Service
public class UserServiceImpl  implements UserService{
@Autowired
	private UserRepo userRepo;
	@Override
	public User createUser(User user) {
	return  userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
  List<User> allUser =userRepo.findAll();
  return allUser;
	}

	@Override
	public User getUserById(int id) {
		    return userRepo.findById(id)
		                   .orElseThrow(() -> new UserException("User not found"));
		}


	@Override
	public User deleteUserById(int id) {
		
		    User  delteUser= userRepo.findById(id)
		                   .orElseThrow(() -> new UserException("User not found"));
		   userRepo.delete(delteUser);
		   return delteUser;
		}

	}


