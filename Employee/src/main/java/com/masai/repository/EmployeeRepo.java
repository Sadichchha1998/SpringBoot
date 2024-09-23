package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Address;
import com.masai.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	public Employee findByEmail(String email);

	public List<Employee> findByAddress(String address);

	// Custom query to find by Address
	//public List<Employee> findByAddressStateAndAddressCityAndAddressPincode(String state, String city, String pincode);

	public List<Employee> findByAddress(Address address);
}
