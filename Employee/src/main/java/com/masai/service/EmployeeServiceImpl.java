package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.EmployeeException;
import com.masai.model.Address;
import com.masai.model.Employee;
import com.masai.model.EmployeeDTO;
import com.masai.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl  implements EmployeeService{
    @Autowired
	private EmployeeRepo empRepo;
	@Override
	public Employee registerEmployee(Employee emp) throws EmployeeException {
	return empRepo.save(emp);
	}

	@Override
	public Employee getEmployeeById(Integer empId) throws EmployeeException {
	Employee emp=	empRepo.findById(empId).orElseThrow(()-> new EmployeeException("Employee not found"));
	return emp;
	}

	@Override
	public List<Employee> getAllEmployeeDetails() throws EmployeeException {
		
	List<Employee> emps=	empRepo.findAll();
	if(emps.isEmpty()) {
		throw new EmployeeException("Employee not found");
	} else {
		return emps;
	}
	}

	@Override
	public Employee deleteEmployeeById(Integer empId) throws EmployeeException {
	Employee empl= empRepo.findById(empId).orElseThrow(()-> new EmployeeException("Employee not found"));
	empRepo.delete(empl);
	return empl;
	}

	@Override
	public Employee loginEmployee(String email, String password) throws EmployeeException {
	     Employee getEmp=    empRepo.findByEmail(email);
	     if(getEmp.equals(getEmp)) {
	    	 getEmp.getEmail();
	    	 getEmp.getPassword();
	    	 return getEmp;
	     } else {
	    	 throw new EmployeeException("Employee not found...");
	     }
	}

//	@Override
//	public List<Employee> getEmployeeDetailsByAddress(Address address) throws EmployeeException {
//		
//		   List<Employee> employees = empRepo.findByAddress(address);
//
//		    if (employees.isEmpty()) {
//		        throw new EmployeeException("No employee found with the given address");
//		    } else {
//		        return employees;
//		    } 	
//	}

	@Override
	public Employee updateEmployee(Employee emp , Integer empId) throws EmployeeException {
		// TODO Auto-generated method stub
		Employee empl= empRepo.findById(empId).orElseThrow(()-> new EmployeeException("Employee not found"));
		empl.getEmpName(empl.setEmpName(empName));
		
		return null;
	}

	@Override
	public String getNameAndAddressOfEmplyeeById(Integer empId) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDTO> getNameAddressSalaryOfAllEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
