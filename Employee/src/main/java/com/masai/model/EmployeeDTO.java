package com.masai.model;

import jakarta.persistence.Embedded;

public class EmployeeDTO {
	private String empName;
	private Integer salary;
	//has-A relationship
	@Embedded
	private Address addr;

}
