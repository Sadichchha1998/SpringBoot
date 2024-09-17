package com.masai.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roll;
	private String name;
	private Integer marks;
	//has-A relationship
	@Embedded
	private Address addr;
	// If one student has one address then Embedded is ok .
	// But if when it have multiple address then you have to use @elementColletction
	//or use attribute Override
	
	//private List<Course> course=  new ArrayList<>(); 
	// if we use list in that case you need to use equals and hascode method
	//By using @Json ignore recursive problem is gone
	  @JsonIgnore
	    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	    @JoinTable(
	        name = "student_course",
	        joinColumns = @JoinColumn(name = "studentId"),
	        inverseJoinColumns = @JoinColumn(name = "courseId")
	    )
	private Set<Course> courses= new HashSet<>();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(addr, other.addr) && Objects.equals(marks, other.marks)
				&& Objects.equals(name, other.name) && Objects.equals(roll, other.roll);
	}

	@Override
	public int hashCode() {
		return Objects.hash(addr, marks, name, roll);
	}


	
	// in this case we use set in both side we need to use equals and hascode by excluding other side variable value

	
}
