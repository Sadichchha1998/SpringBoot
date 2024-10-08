package com.masai.service;

import java.util.List;

import com.masai.exception.EmployeeException;
import com.masai.model.Address;
import com.masai.model.Employee;
import com.masai.model.EmployeeDTO;

public interface EmployeeService {

	public Employee registerEmployee(Employee emp) throws EmployeeException;

	public Employee getEmployeeById(Integer empId) throws EmployeeException;

	public List<Employee> getAllEmployeeDetails() throws EmployeeException;

	public Employee deleteEmployeeById(Integer empId) throws EmployeeException;

	public Employee loginEmployee(String email, String password) throws EmployeeException;

	//public List<Employee> getEmployeeDetailsByAddress(Address address) throws EmployeeException;

	public Employee updateEmployee(Employee emp,Integer empId) throws EmployeeException;

	public String getNameAndAddressOfEmplyeeById(Integer empId) throws EmployeeException;

	public List<EmployeeDTO> getNameAddressSalaryOfAllEmployee() throws EmployeeException;

}
