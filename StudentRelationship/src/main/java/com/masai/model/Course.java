package com.masai.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;
	private String courseName;
	private Integer fee;
	

//one course can have multiple student
// mappedBy is used to reduce one table
// and mapped by value is their side variable field
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, mappedBy = "courses")
	private Set<Student> students = new HashSet<>();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(courseId, other.courseId) && Objects.equals(courseName, other.courseName)
				&& Objects.equals(fee, other.fee);
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseId, courseName, fee);
	}




// I have used set in both type so i need to use equals and hashcode
	//by excluding student that is other side class


}
